package org.imathrowback.mapgen;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MapInfo")
public class MapInfo
{
	int width;
	int height;
	java.util.List<Zone> zones = new ArrayList<>();
	java.util.List<Scene> scenes = new ArrayList<>();
	java.util.List<Teleport> teleports = new ArrayList<>();
}
