package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 160 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_160")
public class _160 
{
	public _160(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	_161 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 160);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_161.class,obj, 2);
	}
}
