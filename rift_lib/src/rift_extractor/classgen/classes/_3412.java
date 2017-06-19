package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3412 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3412")
public class _3412 
{
	public _3412(){}
	java.util.List<_3402> unk0;
	java.util.List<_3402> unk1;
	java.util.List<_3402> unk2;
	java.util.List<_3402> unk3;
	java.util.List<_3402> unk4;
	java.util.List<_3402> unk5;
	java.util.List<_3402> unk6;
	java.util.List<_3402> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3412);

		unk0 = ClassUtils.list(_3402.class,obj,0);
		unk1 = ClassUtils.list(_3402.class,obj,1);
		unk2 = ClassUtils.list(_3402.class,obj,2);
		unk3 = ClassUtils.list(_3402.class,obj,3);
		unk4 = ClassUtils.list(_3402.class,obj,4);
		unk5 = ClassUtils.list(_3402.class,obj,5);
		unk6 = ClassUtils.list(_3402.class,obj,6);
		unk7 = ClassUtils.list(_3402.class,obj,7);
	}
}
