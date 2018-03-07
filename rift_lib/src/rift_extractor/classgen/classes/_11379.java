package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11379 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11379")
public class _11379 
{
	public _11379(){}
	Object unk0;
	java.lang.String unk1;
	TextEntry unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11379);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
	}
}
