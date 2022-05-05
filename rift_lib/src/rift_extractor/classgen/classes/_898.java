package rift_extractor.classgen.classes;

import java.util.Date;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 898 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_898")
public class _898
{
	public _898()
	{
	}

	public Date getStartTime()
	{
		return startTime;
		//return CFileTimeConvertor.getDate(startTime);
	}

	public java.lang.Float unk0;
	public Date startTime;
	public java.util.HashMap<java.lang.Long, _887> unk2;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 898);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class, obj, 0);
		startTime = (ClassUtils.getFieldMember(java.util.Date.class, obj, 1));
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class, obj, 2);
	}
}
