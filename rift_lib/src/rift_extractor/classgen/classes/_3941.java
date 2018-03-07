package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3941 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3941")
public class _3941 
{
	public _3941(){}
	java.lang.String unk0;
	TextEntry unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3941);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
	}
}
