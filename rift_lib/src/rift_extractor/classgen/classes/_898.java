package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 898 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_898")
public class _898 
{
	public _898(){}
	java.lang.Float unk0;
	java.lang.Double unk1;
	java.util.HashMap<java.lang.Long,_887> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 898);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
	}
}
