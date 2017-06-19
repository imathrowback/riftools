package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2240 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2240")
public class _2240 
{
	public _2240(){}
	java.lang.Float unk0;
	java.lang.Long unk1;
	java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2240);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
