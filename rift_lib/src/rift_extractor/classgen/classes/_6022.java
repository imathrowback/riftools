package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6022 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6022")
public class _6022 
{
	public _6022(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_6023> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6022);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
