package rift_extractor.util;

import java.util.Arrays;

public abstract class OS
{

	public static final char[] INVALID_RESOURCE_CHARACTERS;
	private static final String[] INVALID_RESOURCE_BASENAMES;

	static
	{
		//find out the OS being used
		//setup the invalid names
		//valid names and characters taken from http://msdn.microsoft.com/library/default.asp?url=/library/en-us/fileio/fs/naming_a_file.asp
		INVALID_RESOURCE_CHARACTERS = new char[] { '\\', '/', ':', '*', '?', '"', '<', '>', '|', '(', ')' };
		INVALID_RESOURCE_BASENAMES = new String[] { "aux", "com1", "com2", "com3", "com4", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				"com5", "com6", "com7", "com8", "com9", "con", "lpt1", "lpt2", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				"lpt3", "lpt4", "lpt5", "lpt6", "lpt7", "lpt8", "lpt9", "nul", "prn" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
		Arrays.sort(INVALID_RESOURCE_BASENAMES);
	}

	/**
	 * Returns true if the given name is a valid resource name on this operating system,
	 * and false otherwise.
	 */
	public static boolean isNameValid(final String name)
	{
		//. and .. have special meaning on all platforms
		if (name.equals(".") || name.equals("..")) //$NON-NLS-1$ //$NON-NLS-2$
			return false;
		//empty names are not valid
		final int length = name.length();
		if (length == 0)
			return false;
		final char lastChar = name.charAt(length - 1);
		// filenames ending in dot are not valid
		if (lastChar == '.')
			return false;
		// file names ending with whitespace are truncated (bug 118997)
		if (Character.isWhitespace(lastChar))
			return false;
		int dot = name.indexOf('.');
		//on windows, filename suffixes are not relevant to name validity
		String basename = dot == -1 ? name : name.substring(0, dot);
		if (Arrays.binarySearch(INVALID_RESOURCE_BASENAMES, basename.toLowerCase()) >= 0)
			return false;
		return true;
	}
}