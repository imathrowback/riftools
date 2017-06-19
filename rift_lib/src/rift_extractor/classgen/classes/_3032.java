package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3032 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3032")
public class _3032 
{
	public _3032(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3032);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
