package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7620 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7620")
public class _7620 
{
	public _7620(){}
	java.lang.String unk0;
	TextEntry unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7620);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
	}
}
