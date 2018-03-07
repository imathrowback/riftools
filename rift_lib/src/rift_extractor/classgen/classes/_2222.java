package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2222 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2222")
public class _2222 
{
	public _2222(){}
	TextEntry unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2222);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
