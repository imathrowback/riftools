package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 4321 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4321")
public class _4321
{
	public _4321()
	{
	}

	public java.util.List<_4320> unk0;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 4321);

		unk0 = ClassUtils.list(_4320.class, obj, 0);
	}
}
