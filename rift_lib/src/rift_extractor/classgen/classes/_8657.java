package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8657 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8657")
public class _8657 
{
	public _8657(){}
	public java.util.List<_8656> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8657);

		unk0 = ClassUtils.list(_8656.class,obj,0);
	}
}
