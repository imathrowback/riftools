package org.imathrowback.telaradbdiff;

import org.imathrowback.datparser.CObject;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("Entry")
public class Entry
{
	@XStreamAsAttribute
	long id;
	@XStreamAsAttribute
	long key;
	CObject obj;
	@XStreamOmitField
	public String sortKey;
}