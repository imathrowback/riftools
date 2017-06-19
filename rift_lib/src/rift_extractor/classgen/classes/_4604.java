package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4604 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4604")
public class _4604 
{
	public _4604(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.HashMap<java.lang.Long,_307> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4604);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
