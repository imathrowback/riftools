package org.imathrowback.telaradb;

import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.Pair;

public interface TelaraDBInterface
{

	public Stream<Pair<Integer, Integer>> getIdsAndKeys();

	/** Get the data associated with the given id and key */
	public byte[] getData(Integer datasetid, Integer key);

	default public Stream<Integer> getKeys()
	{
		return getIdsAndKeys().map(r -> r.getRight());
	}

	default public Stream<Integer> getIds()
	{
		return getIdsAndKeys().map(r -> r.getLeft());
	}

	default public Stream<Integer> getKeys(final Integer i)
	{
		return getIdsAndKeys().filter(x -> x.getLeft() == i).map(r -> r.getRight());
	}
}