export const LZMA2Decoder = {
  async decompress(lzma2Data, uncompressedSize) {
    if (typeof xzwasm === 'undefined') throw new Error('xzwasm is not loaded.');
    const xzData = this.wrapXZ(lzma2Data, uncompressedSize);
    const xzStream = new xzwasm.XzReadableStream(new Blob([xzData]).stream());
    return await new Response(xzStream).arrayBuffer();
  },

  wrapXZ(lzma2, uncompSize) {
    const dictByte = this.calcDictByte(Math.max(4096, uncompSize * 2));
    const vli = n => {
      const b = [];
      while (n >= 0x80) { b.push((n & 0x7F) | 0x80); n = Math.floor(n / 128); }
      b.push(n);
      return new Uint8Array(b);
    };
    const le32 = n => new Uint8Array([n & 0xFF, n >> 8 & 0xFF, n >> 16 & 0xFF, n >> 24 & 0xFF]);
    const pad4 = n => new Uint8Array((4 - n % 4) % 4);
    const cat = (...aa) => {
      const out = new Uint8Array(aa.reduce((s, a) => s + a.length, 0));
      let i = 0;
      for (const a of aa) { out.set(a, i); i += a.length; }
      return out;
    };
    const crc32 = data => {
      let c = 0xFFFFFFFF;
      for (const b of data) {
        c ^= b;
        for (let i = 0; i < 8; i++) c = (c >>> 1) ^ (c & 1 ? 0xEDB88320 : 0);
      }
      return (c ^ 0xFFFFFFFF) >>> 0;
    };

    const streamFlags = new Uint8Array([0x00, 0x00]);
    const streamHeader = cat(new Uint8Array([0xFD, 0x37, 0x7A, 0x58, 0x5A, 0x00]), streamFlags, le32(crc32(streamFlags)));
    const hBody = cat(new Uint8Array([0xC0]), vli(lzma2.length), vli(uncompSize), vli(0x21), vli(1), new Uint8Array([dictByte]));
    const hPad = pad4(hBody.length + 1);
    const hSizeByte = new Uint8Array([(1 + hBody.length + hPad.length) / 4]);
    const hForCRC = cat(hSizeByte, hBody, hPad);
    const blockHeader = cat(hForCRC, le32(crc32(hForCRC)));
    const unpaddedSize = blockHeader.length + lzma2.length + pad4(lzma2.length).length;
    const idxBody = cat(new Uint8Array([0x00]), vli(1), vli(unpaddedSize), vli(uncompSize));
    const idxPad = pad4(idxBody.length);
    const idxFull = cat(idxBody, idxPad);
    const index = cat(idxFull, le32(crc32(idxFull)));
    const bwSize = le32(index.length / 4 - 1);
    const footer = cat(le32(crc32(cat(bwSize, streamFlags))), bwSize, streamFlags, new Uint8Array([0x59, 0x5A]));

    return cat(streamHeader, blockHeader, lzma2, pad4(lzma2.length), index, footer);
  },

  calcDictByte: (size) => {
    for (let d = 0; d < 40; d++) {
      if ((d % 2 === 0 ? 2 ** (d / 2 + 12) : 3 * 2 ** ((d - 1) / 2 + 11)) >= size) return d;
    }
    return 40;
  }
};

export const DDSRenderer = {
  render(buffer, canvas) {
    const header = new Int32Array(buffer, 0, 32);
    if (header[0] !== 0x20534444) throw new Error('Not a valid DDS file');

    const height = header[3];
    const width = header[4];
    const fourCC = header[21]; 
    
    const off = 128;
    const ctx = canvas.getContext('2d');
    canvas.width = width;
    canvas.height = height;
    const imgData = ctx.createImageData(width, height);

    if (fourCC === 0x31545844) { // DXT1
      this.decodeDXT1(new Uint8Array(buffer, off), width, height, imgData.data);
    } else if (fourCC === 0x35545844) { // DXT5
      this.decodeDXT5(new Uint8Array(buffer, off), width, height, imgData.data);
    }

    ctx.putImageData(imgData, 0, 0);
  },

  decodeDXT1(data, width, height, rgba) {
    let offset = 0;
    for (let y = 0; y < height; y += 4) {
      for (let x = 0; x < width; x += 4) {
        const c0 = data[offset] | (data[offset + 1] << 8);
        const c1 = data[offset + 2] | (data[offset + 3] << 8);
        
        // Unpack RGB565
        const colors = this.unpack565(c0, c1);
        const lookup = (data[offset + 4]) | (data[offset + 5] << 8) | (data[offset + 6] << 16) | (data[offset + 7] << 24);
        
        for (let j = 0; j < 4; j++) {
          for (let i = 0; i < 4; i++) {
            const idx = (lookup >> (2 * (j * 4 + i))) & 0x03;
            const px = ((y + j) * width + (x + i)) * 4;
            
            let r, g, b, a = 255;
            if (c0 > c1) {
              const table = [
                colors[0], colors[1], colors[2], // c0
                colors[3], colors[4], colors[5], // c1
                (2 * colors[0] + colors[3]) / 3, (2 * colors[1] + colors[4]) / 3, (2 * colors[2] + colors[5]) / 3,
                (colors[0] + 2 * colors[3]) / 3, (colors[1] + 2 * colors[4]) / 3, (colors[2] + 2 * colors[5]) / 3
              ];
              r = table[idx * 3]; g = table[idx * 3 + 1]; b = table[idx * 3 + 2];
            } else {
              const table = [
                colors[0], colors[1], colors[2], // c0
                colors[3], colors[4], colors[5], // c1
                (colors[0] + colors[3]) / 2, (colors[1] + colors[4]) / 2, (colors[2] + colors[5]) / 2,
                0, 0, 0 // Transparent black
              ];
              r = table[idx * 3]; g = table[idx * 3 + 1]; b = table[idx * 3 + 2];
              if (idx === 3) a = 0;
            }
            rgba.set([r, g, b, a], px);
          }
        }
        offset += 8;
      }
    }
  },

  decodeDXT5(data, width, height, rgba) {
    let offset = 0;
    for (let y = 0; y < height; y += 4) {
      for (let x = 0; x < width; x += 4) {
        // Correctly handling 48-bit alpha indices using BigInt or byte-slicing
        const alphas = this.getDXT5Alphas(data[offset], data[offset + 1]);
        const alphaIndices = data.subarray(offset + 2, offset + 8);
        
        const c0 = data[offset + 8] | (data[offset + 9] << 8);
        const c1 = data[offset + 10] | (data[offset + 11] << 8);
        const colors = this.unpack565(c0, c1);
        const colorTable = [
          colors[0], colors[1], colors[2],
          colors[3], colors[4], colors[5],
          (2 * colors[0] + colors[3]) / 3, (2 * colors[1] + colors[4]) / 3, (2 * colors[2] + colors[5]) / 3,
          (colors[0] + 2 * colors[3]) / 3, (colors[1] + 2 * colors[4]) / 3, (colors[2] + 2 * colors[5]) / 3
        ];

        const colorLookup = (data[offset + 12]) | (data[offset + 13] << 8) | (data[offset + 14] << 16) | (data[offset + 15] << 24);

        for (let j = 0; j < 4; j++) {
          for (let i = 0; i < 4; i++) {
            const pixelIdx = j * 4 + i;
            
            // Extract 3-bit alpha index safely
            const bitOffset = pixelIdx * 3;
            const byteIdx = Math.floor(bitOffset / 8);
            const bitShift = bitOffset % 8;
            let aIdx = (alphaIndices[byteIdx] | (alphaIndices[byteIdx + 1] << 8)) >> bitShift;
            aIdx &= 0x07;

            const cIdx = (colorLookup >> (pixelIdx * 2)) & 0x03;
            const px = ((y + j) * width + (x + i)) * 4;

            rgba.set([
              colorTable[cIdx * 3], 
              colorTable[cIdx * 3 + 1], 
              colorTable[cIdx * 3 + 2], 
              alphas[aIdx]
            ], px);
          }
        }
        offset += 16;
      }
    }
  },

  unpack565(c0, c1) {
    const r0 = (c0 >> 11) & 0x1F, g0 = (c0 >> 5) & 0x3F, b0 = c0 & 0x1F;
    const r1 = (c1 >> 11) & 0x1F, g1 = (c1 >> 5) & 0x3F, b1 = c1 & 0x1F;
    // Standard bit-replication for 565 to 888 conversion
    return [
      (r0 << 3) | (r0 >> 2), (g0 << 2) | (g0 >> 4), (b0 << 3) | (b0 >> 2),
      (r1 << 3) | (r1 >> 2), (g1 << 2) | (g1 >> 4), (b1 << 3) | (b1 >> 2)
    ];
  },

  getDXT5Alphas(a0, a1) {
    const alphas = [a0, a1];
    if (a0 > a1) {
      for (let i = 1; i < 7; i++) alphas.push(((7 - i) * a0 + i * a1) / 6);
    } else {
      for (let i = 1; i < 5; i++) alphas.push(((5 - i) * a0 + i * a1) / 4);
      alphas.push(0, 255);
    }
    return alphas;
  }
};