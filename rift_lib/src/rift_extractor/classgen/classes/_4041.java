package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4041 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4041")
public class _4041 
{
	public _4041(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4041);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
