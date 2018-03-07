package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7712 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7712")
public class _7712 
{
	public _7712(){}
	Object unk0;
	TextEntry unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7712);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
	}
}
