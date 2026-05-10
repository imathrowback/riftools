# On-Demand Asset Preview in Manifest Diff

## Goal

When viewing a ManifestDiff HTML report, the user can click a "Preview" button
on any changed/added/deleted row to fetch the actual asset data from RIFT's CDN
(via HTTP Range) and display it inline — an image preview for textures, or a
hex viewer for other file types.

## Architecture

No local extraction at generation time. The Java HTML formatter embeds enough
metadata into the HTML for JavaScript to fetch and render on demand.

## Data flow

### 1. Generation time (Java, HtmlFormatter.java)

For each diff entry row (changed/added/deleted), embed:

```html
<tr data-pak-url="http://cdn/.../assetspak_XXXX.pak"
    data-entry-hash="A1B2C3D4"
    data-pak-offset="123456"
    data-pak-csize="9876"
    data-pak-usize="15000"
    data-filename="some_texture.dds"
    data-compression="lzma2">
  ...
  <td class="preview-cell"><button class="preview-btn">Preview</button></td>
</tr>
```

- `data-pak-url` — CDN URL of the PAK file containing this asset
- `data-entry-hash` — 4-byte filename hash (for identifying the entry in logs)
- `data-pak-offset` — exact byte offset of the entry data in the PAK file
- `data-pak-csize` — compressed size (0 = uncompressed, same as usize)
- `data-pak-usize` — uncompressed size
- `data-filename` — resolved filename (to determine if image or binary)
- `data-compression` — "lzma2" or "none"

These are read from `ManifestPAKFileEntry` + `PAKEntry` at generation time.

### 2. Fetch (JavaScript)

When user clicks "Preview":

```js
const url = row.dataset.pakUrl;
const offset = parseInt(row.dataset.pakOffset);
const csize = parseInt(row.dataset.pakCsize);

const response = await fetch(url, {
  headers: { Range: `bytes=${offset}-${offset + csize - 1}` }
});
const compressed = await response.arrayBuffer();
```

This is a single HTTP Range request — no PAK header parsing needed.

### 3. Decompress (JavaScript)

If `compression === "lzma2"`:
- Skip first byte (flags/dictionary size)
- Decompress rest as LZMA2 stream using a JS LZMA2 decoder

If `compression === "none"`:
- Use raw bytes directly

**LZMA2 JS library**: Use a small inline WASM build of LZMA2, or port the
minimal decompression logic. Target: ~5KB gzipped.

### 4. Render (JavaScript)

#### For images (filename ends in .dds, .png, .jpg, etc.)

**DDS decoding pipeline:**

1. Parse DDS header (4 bytes magic "DDS ", header size, flags, dimensions,
   pixel format, DX10 header extension for BC4/BC5/BC6/BC7)
2. Identify block compression format:
   - `DXT1`/`BC1` → 4bpp, color + 1-bit alpha
   - `DXT3`/`BC2` → 8bpp, color + explicit alpha
   - `DXT5`/`BC3` → 8bpp, color + interpolated alpha
   - `BC4` → 4bpp, single-channel
   - `BC5` → 8bpp, two-channel (normal maps)
   - `BC6H` → 8bpp, HDR (skip for preview)
   - `BC7` → 8bpp, high-quality RGB(A)
3. Decode block by block to RGBA pixels
4. Draw to `<canvas>` with `putImageData()`

For non-power-of-2 textures or large textures, scale down to a max of 512px.

**Non-DDS images** (.png, .jpg, etc.): Use `URL.createObjectURL(new Blob([data]))`
and set as `<img src>`.

#### For non-image files

Display a hex viewer:

```
Offset   00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F  ASCII
--------  -------------------------------------------------  ----------------
00000000  89 50 4E 47 0D 0A 1A 0A 00 00 00 0D 49 48 44 52  .PNG........IHDR
00000010  00 00 00 10 00 00 00 10 08 02 00 00 00 90 6F 87  ..............o.
```

- First 128 bytes only (or full file for small files < 4KB)
- Click to expand to full file

### 5. UI treatment

- Each row gets a "Preview" button in a new rightmost column
- Click opens an overlay/lightbox within the page (no navigation)
- Overlay shows either:
  - Image preview (centered, max 512px, or full-size toggle)
  - Hex viewer (monospace, scrollable)
- Close button or click-outside to dismiss

## Files to modify

### Java
- `ManifestDiff/src/org/imathrowback/manifest/diff/HtmlFormatter.java`
  - After rendering each row, inject `data-*` attributes on `<tr>`
  - Need access to the PAK entries to find offset/csize for each manifest entry
  - Need the PAK URL from the manifest
  - Add a "Preview" column header and cell

### JavaScript (injected into manifest.html by HtmlFormatter.java)
- DDS decoder (BC1-BC7 block decompression)
- LZMA2 decompressor
- Hex viewer renderer
- Preview overlay UI + event handlers

## Implementation order

1. Modify `HtmlFormatter.java` to embed `data-*` attributes on diff rows
2. Add Preview column
3. Add inline JS for the preview overlay, fetch, and render pipeline
4. Test with a real pair

## LZMA2 decompression in JS

LZMA2 is a stream format. The compressed payload is:
- 1 byte: flags (dictionary size, etc.)
- Remaining: LZMA2 stream chunks

Key decompression steps:
- Read LZMA properties (lc, lp, pb) from first chunk
- Range decoder
- LZ77 match + literal decoder
- Output bytes

Can use wasm-pack to compile xz-embedded C library, or port a minimal decoder.
