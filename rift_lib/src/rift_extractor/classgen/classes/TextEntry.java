package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 7703 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("ID")
public class TextEntry
{
	public TextEntry()
	{
	}

	public java.lang.Integer unk0;
	public String tempText;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 7703);

		unk0 = ClassUtils.getFieldMember(java.lang.Integer.class, obj, 0);
		tempText = ClassUtils.getFieldMember(java.lang.String.class, obj, 1);
	}
}
