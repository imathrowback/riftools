package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11109 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11109")
public class _11109 
{
	public _11109(){}
	Object unk0;
	java.lang.String unk1;
	_11102 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11109);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_11102.class,obj, 2);
	}
}
