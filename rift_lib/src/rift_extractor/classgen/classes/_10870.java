package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10870 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10870")
public class _10870 
{
	public _10870(){}
	java.lang.String unk0;
	java.util.HashMap<java.lang.Long,_303> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10870);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
