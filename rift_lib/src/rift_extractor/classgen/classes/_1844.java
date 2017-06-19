package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1844 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1844")
public class _1844 
{
	public _1844(){}
	Object unk0;
	public _1845 unk1;
	public _1845 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1844);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(_1845.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_1845.class,obj, 2);
	}
}
