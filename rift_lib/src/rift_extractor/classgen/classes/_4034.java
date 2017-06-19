package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4034 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4034")
public class _4034 
{
	public _4034(){}
	Object unk0;
	java.util.HashMap<java.lang.Long,_3941> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4034);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
