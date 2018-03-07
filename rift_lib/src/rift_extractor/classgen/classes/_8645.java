package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8645 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8645")
public class _8645 
{
	public _8645(){}
	Object unk0;
	TextEntry unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8645);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
	}
}
