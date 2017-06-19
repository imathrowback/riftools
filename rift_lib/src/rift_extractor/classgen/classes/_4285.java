package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4285 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4285")
public class _4285 
{
	public _4285(){}
	public ID unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4285);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
	}
}
