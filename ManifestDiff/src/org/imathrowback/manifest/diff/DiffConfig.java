package org.imathrowback.manifest.diff;

public class DiffConfig
{
	private DiffKeyStrategy keyStrategy = DiffKeyStrategy.FILENAME_HASH_AND_LENGTH_AND_ASSET_ID;
	private int onlyLang = -1;
	private boolean detectRenames = true;
	private boolean trackPakMoves = true;
	private boolean trackSizeChanges = false;

	public DiffConfig()
	{
	}

	public DiffKeyStrategy getKeyStrategy()
	{
		return keyStrategy;
	}

	public DiffConfig setKeyStrategy(final DiffKeyStrategy keyStrategy)
	{
		this.keyStrategy = keyStrategy;
		return this;
	}

	public int getOnlyLang()
	{
		return onlyLang;
	}

	public DiffConfig setOnlyLang(final int onlyLang)
	{
		this.onlyLang = onlyLang;
		return this;
	}

	public boolean isDetectRenames()
	{
		return detectRenames;
	}

	public DiffConfig setDetectRenames(final boolean detectRenames)
	{
		this.detectRenames = detectRenames;
		return this;
	}

	public boolean isTrackPakMoves()
	{
		return trackPakMoves;
	}

	public DiffConfig setTrackPakMoves(final boolean trackPakMoves)
	{
		this.trackPakMoves = trackPakMoves;
		return this;
	}

	public boolean isTrackSizeChanges()
	{
		return trackSizeChanges;
	}

	public DiffConfig setTrackSizeChanges(final boolean trackSizeChanges)
	{
		this.trackSizeChanges = trackSizeChanges;
		return this;
	}

	public boolean shouldIncludeLang(final int lang)
	{
		if (onlyLang <= 0)
			return true;
		if (lang == 0)
			return true;
		return lang == onlyLang;
	}
}
