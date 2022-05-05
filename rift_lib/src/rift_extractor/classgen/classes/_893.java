package rift_extractor.classgen.classes;

import java.util.Date;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 893 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_893")
public class _893
{
	public _893()
	{
	}

	public TextEntry unk0;
	public java.util.List<_898> unk1;
	public TextEntry unk2;
	public java.lang.Long unk3;
	public Date endTime;
	public java.util.HashMap<java.lang.Long, _676> unk5;
	public java.lang.Boolean unk6;
	public java.lang.Long unk7;

	public Date getEndTime()
	{
		return endTime;
		//return CFileTimeConvertor.getDate(endTime);
	}

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 893);

		unk0 = ClassUtils.getFieldMember(TextEntry.class, obj, 0);
		unk1 = ClassUtils.list(_898.class, obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class, obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 3);
		endTime = ClassUtils.getFieldMember(java.util.Date.class, obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class, obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class, obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 7);
	}
}
