package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 152 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_152")
public class _152 
{
	public _152(){}
	TextEntry unk0;
	java.util.HashMap<java.lang.Long,_151> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 152);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
