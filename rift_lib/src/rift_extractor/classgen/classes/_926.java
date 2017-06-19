package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 926 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_926")
public class _926 
{
	public _926(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.util.List<java.lang.Long> unk1;
	java.util.List<java.lang.Long> unk2;
	java.util.List<java.lang.Long> unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<_863> unk6;
	java.util.List<_863> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 926);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(_863.class,obj,6);
		unk7 = ClassUtils.list(_863.class,obj,7);
	}
}
