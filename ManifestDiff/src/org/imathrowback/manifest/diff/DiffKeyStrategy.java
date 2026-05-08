package org.imathrowback.manifest.diff;

import rift_extractor.assets.ManifestEntry;

public enum DiffKeyStrategy
{
	FILENAME_HASH
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.filenameHashStr;
		}

		@Override
		public boolean supportsRenames()
		{
			return true;
		}
	},
	FILENAME_HASH_AND_LENGTH
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.filenameHashStr + ":" + entry.filenameLength;
		}

		@Override
		public boolean supportsRenames()
		{
			return true;
		}
	},
	FILENAME_HASH_AND_LANG
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.filenameHashStr + ":" + entry.lang;
		}

		@Override
		public boolean supportsRenames()
		{
			return true;
		}
	},
	FILENAME_HASH_AND_LENGTH_AND_ASSET_ID
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.filenameHashStr + ":" + entry.filenameLength + ":" + entry.idStr;
		}

		@Override
		public boolean supportsRenames()
		{
			return true;
		}
	},
	ASSET_ID
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.idStr;
		}

		@Override
		public boolean supportsRenames()
		{
			return false;
		}
	},
	SHA
	{
		@Override
		public String getKey(final ManifestEntry entry)
		{
			return entry.shaStr;
		}

		@Override
		public boolean supportsRenames()
		{
			return false;
		}
	};

	public abstract String getKey(ManifestEntry entry);

	public abstract boolean supportsRenames();
}
