package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 770 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_770")
public class _770 
{
	public _770(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3600> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 770);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
