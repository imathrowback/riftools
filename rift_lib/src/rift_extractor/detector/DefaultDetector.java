package rift_extractor.detector;

import java.util.LinkedList;
import java.util.List;

public class DefaultDetector
{
	List<Detector> detectors = new LinkedList<>();

	public DefaultDetector(final List<Detector> detectors2)
	{
		if (detectors2 == null)
			detectors = getDetectors();
		else
			detectors.addAll(detectors2);
	}

	public static List<Detector> getDetectors()
	{
		List<Detector> detectors = new LinkedList<>();
		// INTERESTING
		detectors.add(new SimpleStartWithDetector("<?xml", "xml", "XML files")); // XML file - appears to contain stuff like bone layouts?

		detectors.add(new SimpleStartWithDetector("BM8", "bmp", "BMP Bitmap")); // BMP file

		detectors.add(new SimpleStartWithDetector("BIK", "bik", "BINK video")); // Bink video
		detectors.add(new SimpleStartWithDetector("Gameb", "nif", "Gamebryo NIF")); // gamebryo NIF
		detectors.add(new SimpleStartWithDetector(";Gameb", "kfm", "Gamebryo KFM (keyframes)")); // gamebryo KFM
		detectors.add(new SimpleStartWithDetector("BKHD", "bnk", "WWise SoundBank")); // sound bank
		detectors.add(new SimpleStartWithDetector("DDS", "dds", "DirectX DDS")); // graphics
		detectors.add(new SimpleStartWithDetector("RIFF", "wav", "WWise RIFF Vorbis")); // generic sound
		detectors.add(new SimpleStartWithDetector("GFX", "gfx", "Scaleform GFX")); // flash GFX file
		// Some kind of map I think, possibly the "Actual" game maps
		// there definitely appears to be collision references and other NIF files. Groups of NIF files maybe?
		// also contains references to "chunk"
		detectors.add(new SimpleByteDetector(new byte[] { 0x6B, 0x1f, }, "_unk_map1", "Unknown possibly map data"));
		detectors.add(new SimpleByteDetector(new byte[] { 0x6B, 0x0e, }, "_unk_map2", "Unknown possibly map data"));// Possibly related to above based on the identical first byte.
		detectors.add(new SimpleByteDetector(new byte[] { 0x69, 0x06, }, "_unk_map3", "Unknown possibly map data"));// Unsure, has stuff like pd_trove and pd_fetid_plains
		detectors.add(new SimpleByteDetector(new byte[] { 0x57, (byte) 0xE0, (byte) 0xE0 }, "_unk_havoc",
				"Unknown possibly HAVOC (physics) data")); // Some kind of HAVOC file
		detectors.add(new SimpleByteDetector(new byte[] { (byte) 0xD2, 0x1D, 0x1F, }, "_unk_encrypted",
				"Unknown possibly encrypted")); // No idea at all, possibly encrypted?

		detectors.add(new SimpleStartWithDetector("--", "lua", "LUA script")); // LUA
		detectors.add(new SimpleContainsDetector("JFIF", 10, "jpg", "JFIF JPEG")); // JPEG
		detectors.add(new SimpleContainsDetector("Exif", 10, "jpg", "EXIF JPEG")); // JPEG
		detectors.add(new SimpleByteDetector(new byte[] { (byte) 0x89, 0x50, 0x4E, 0x47 }, "png", "PNG file")); // PNG
		detectors.add(new FullByteDetector(new String("TRUEVISION-XFILE").getBytes(), "tga", "TGA file")); // TGA

		// shaders/vfx?
		detectors.add(new SimpleByteDetector(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00 }, "unk_shader1",
				"Unknown possibly VFX shader")); // Unknown. - contains references to VFX dds, so maybe some kind of shader?
		detectors.add(
				new SimpleByteDetector(new byte[] { (byte) 0x00, 0x00, 0x00, 0x00, 0x0A, (byte) 0xD7 }, "unk_nif",
						"Unknown NIF references")); // Some kind of NIF reference
		detectors.add(new SimpleByteDetector(new byte[] { 0x00, 0x00, 0x00, 0x00 }, "unk_shader2",
				"Unknown possibly VFX shader")); // Unknown. - contains references to VFX dds, so maybe some kind of shader?
		detectors
				.add(new SimpleByteDetector(new byte[] { (byte) 0x01, 0x09, (byte) 0xFF, (byte) 0xFE }, "unk_shader3",
						"Unknown possibly VFX shader")); // Some kind of shader
		detectors.add(new FullByteDetector(new byte[] { 0x00, 0x76, 0x00, 0x66, 0x00, 0x78, 0x00 }, "unk_shader4",
				"Unknown possibly VFX shader")); // Some kind of VFX
		detectors
				.add(new FullByteDetector(new String("ps_3_0").getBytes(), "pixelshader_3", "Compiled v3 Pixelshader")); // shader
		detectors
				.add(new FullByteDetector(new String("ps_2_0").getBytes(), "pixelshader_2", "Compiled v2 Pixelshader")); // shader

		// no idea
		// STUFF
		detectors.add(new SimpleContainsDetector("DSIG", 500, "ttf", "DSIG TTF")); // TTF file
		detectors.add(new SimpleContainsDetector("OS/2", 500, "ttf", "OS/2 TTF")); // TTF file
		return detectors;
	}

	public String detectExtension(final byte[] data)
	{
		return detectors.stream().filter(d -> d.detect(data) == DetectResult.TRUE).map(d -> d.getExtension())
				.findFirst()
				.orElse(null);
	}

	public String detectExtension2(final byte[] data)
	{
		return detectors.stream().filter(d -> d.detect(data) == DetectResult.TRUE).map(d -> d.getExtension())
				.findFirst()
				.orElse("");
	}
}
