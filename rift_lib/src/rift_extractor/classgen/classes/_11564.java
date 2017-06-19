package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11564 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11564")
public class _11564 
{
	public _11564(){}
	rift_extractor.classgen.Vector4 unk0;
	rift_extractor.classgen.Vector4 unk1;
	rift_extractor.classgen.Vector4 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11564);

		unk0 = ClassUtils.vector4(obj,0);
		unk1 = ClassUtils.vector4(obj,1);
		unk2 = ClassUtils.vector4(obj,2);
	}
}
