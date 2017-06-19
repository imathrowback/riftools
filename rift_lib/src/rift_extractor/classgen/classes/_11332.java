package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11332 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11332")
public class _11332 
{
	public _11332(){}
	public java.util.List<_11333> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11332);

		unk0 = ClassUtils.list(_11333.class,obj,0);
	}
}
