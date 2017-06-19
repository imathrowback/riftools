package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 676 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_676")
public class _676 
{
	public _676(){}
	java.lang.Double unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 676);

		unk0 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 0);
	}
}
