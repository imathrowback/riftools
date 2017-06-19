/*
 * 
 */
package org.imathrowback.datparser;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author imathrowback
 */
public class Convertors
{

	private static <T> ConvertorInfo c(Class<? extends CObjectConverter> aClass)
	{
		return new ConvertorInfo(aClass);
	}
	
	public static List<CObjectConverter> getConvertors()
	{
		return getConvertorInfos().stream().map(i -> 
		{
			try {
				return i.getConvertorClass().newInstance();
			} catch (Exception ex) {
			}
			return null;
		}).filter(x -> x != null).collect(Collectors.toList());
	}

	public static List<ConvertorInfo> getConvertorInfos()
	{
		List<ConvertorInfo> con = new LinkedList();
		con.add(c(CNoConvertor.class));
		con.add(c(CIntConvertor.class));
		con.add(c(CBooleanConvertor.class));
		con.add(c(CDoubleConvertor.class));
		con.add(c(CFileTimeConvertor.class));
		con.add(c(CFloatConvertor.class));
		con.add(c(CHexConvertor.class));
		con.add(c(CLongConvertor.class));
		con.add(c(CSignedVarLongConvertor.class));
		con.add(c(CUnsignedVarLongConvertor.class));
		con.add(c(CStringConvertor.class));
		return con;
	}
	public static ComboBoxModel getList()
	{
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		getConvertorInfos().forEach(model::addElement);
		return model;
	}
	
}
