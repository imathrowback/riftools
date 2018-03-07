package org.imathrowback.mapgen;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Zone")
public class Zone
{
	Long id;
	String name;
	int minLevel;
	int maxLevel;
	public boolean excludeFromMap;
	java.util.List<Float[]> points = new ArrayList<>();
}
