package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 314 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_314")
public class _314 
{
	public _314(){}
	rift_extractor.classgen.Vector4 unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 314);

		unk0 = ClassUtils.vector4(obj,0);
	}
}
