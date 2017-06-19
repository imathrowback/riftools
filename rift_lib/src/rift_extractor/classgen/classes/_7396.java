package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7396 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7396")
public class _7396 
{
	public _7396(){}
	_7400 unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7396);

		unk0 = ClassUtils.getFieldMember(_7400.class,obj, 0);
	}
}
