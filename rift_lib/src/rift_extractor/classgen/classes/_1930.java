package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1930 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1930")
public class _1930 
{
	public _1930(){}
	Object unk0;
	Object unk1;
	java.util.List<_97> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1930);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.list(_97.class,obj,2);
	}
}
