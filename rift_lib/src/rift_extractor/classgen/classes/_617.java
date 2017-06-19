package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 617 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_617")
public class _617 
{
	public _617(){}
	java.lang.String unk0;
	java.util.HashMap<java.lang.Long,_3600> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 617);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
