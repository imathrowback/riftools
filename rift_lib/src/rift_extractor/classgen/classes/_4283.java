package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4283 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4283")
public class _4283 
{
	public _4283(){}
	_307 unk0;
	_307 unk1;
	_307 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4283);

		unk0 = ClassUtils.getFieldMember(_307.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(_307.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_307.class,obj, 2);
	}
}
