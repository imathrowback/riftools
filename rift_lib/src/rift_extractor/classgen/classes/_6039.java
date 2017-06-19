package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6039 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6039")
public class _6039 
{
	public _6039(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6039);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
