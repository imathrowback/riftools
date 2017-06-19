package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 157 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_157")
public class _157 
{
	public _157(){}
	public ID unk0;
	public ID unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 157);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
	}
}
