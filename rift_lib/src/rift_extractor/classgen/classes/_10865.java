package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10865 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10865")
public class _10865 
{
	public _10865(){}
	Object unk0;
	java.util.HashMap<java.lang.Long,_10866> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10865);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
