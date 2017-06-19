package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1776 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1776")
public class _1776 extends _999594
{
	public _1776(){}
	_3600 unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1776);

		unk0 = ClassUtils.getFieldMember(_3600.class,obj, 0);
	}
}
