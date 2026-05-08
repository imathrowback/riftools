package org.imathrowback.telaradbdiff.diff;

import java.io.File;

public class DbDiffConfig
{
	private boolean useJson = false;
	private File outdir;
	private File langA;
	private File langB;
	private boolean autoDownloadLangDB;
	private boolean is64 = true;
	private String format = "text";

	public DbDiffConfig setUseJson(final boolean useJson) { this.useJson = useJson; return this; }
	public boolean isUseJson() { return useJson; }

	public DbDiffConfig setOutdir(final File outdir) { this.outdir = outdir; return this; }
	public File getOutdir() { return outdir; }

	public DbDiffConfig setLangA(final File langA) { this.langA = langA; return this; }
	public File getLangA() { return langA; }

	public DbDiffConfig setLangB(final File langB) { this.langB = langB; return this; }
	public File getLangB() { return langB; }

	public DbDiffConfig setAutoDownloadLangDB(final boolean auto) { this.autoDownloadLangDB = auto; return this; }
	public boolean isAutoDownloadLangDB() { return autoDownloadLangDB; }

	public DbDiffConfig setIs64(final boolean is64) { this.is64 = is64; return this; }
	public boolean is64() { return is64; }

	public DbDiffConfig setFormat(final String format) { this.format = format; return this; }
	public String getFormat() { return format; }
}
