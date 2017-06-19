package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3924 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3924")
public class _3924 
{
	public _3924(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.HashMap<java.lang.Long,_4116> unk0;
	public _3925 unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3924);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(_3925.class,obj, 1);
	}
}
