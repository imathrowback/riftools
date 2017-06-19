package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4663 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4663")
public class _4663 
{
	public _4663(){}
	_3733 unk0;
	java.lang.String unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4663);

		unk0 = ClassUtils.getFieldMember(_3733.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
	}
}
