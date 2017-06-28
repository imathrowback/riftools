/*
 *
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class ClassDefaults
{

	public static CObjectConverter getConv(final int parentType, final int thisType)
	{
		switch (thisType)
		{
			case 5:
			{
				switch (parentType)
				{
					case 4086:
					case 4235:
					case 13154:
						return new CFileTimeConvertor();
				}
				return new CDoubleConvertor();
			}
			case 4:
			{
				switch (parentType)
				{
					case 1035:
					case 7319:
					case 7318:
					case 602:
					case 603:
					case 7703:
						return new CIntConvertor();
				}
				return new CFloatConvertor();
			}
		}

		throw new IllegalArgumentException("Unknown thisTyp[" + thisType + "] and parentType[" + parentType + "]");

		// new CFloatConvertor()
	}
}
