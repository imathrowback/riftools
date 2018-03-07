package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 7711 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7711")
public class _7711
{
	public _7711()
	{
	}

	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String command;
	public java.lang.String name;
	Object unk2;
	public TextEntry unk3;
	public java.lang.Boolean userAllowedMaybe = false;
	public TextEntry unk5;
	public TextEntry unk6;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 7711);

		command = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		name = ClassUtils.getFieldMember(java.lang.String.class, obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class, obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class, obj, 3);
		userAllowedMaybe = ClassUtils.getFieldMember(java.lang.Boolean.class, obj, 4);
		unk5 = ClassUtils.getFieldMember(TextEntry.class, obj, 5);
		unk6 = ClassUtils.getFieldMember(TextEntry.class, obj, 6);
	}
}
