package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 745 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_745")
public class _745 
{
	public _745(){}
	Object unk0;
	public java.util.HashMap<java.lang.Long,_307> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 745);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
