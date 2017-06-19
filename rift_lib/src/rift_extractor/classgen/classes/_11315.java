package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11315 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11315")
public class _11315 
{
	public _11315(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11315);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
