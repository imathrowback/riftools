package org.imathrowback;

import java.util.UUID;

import com.google.common.eventbus.EventBus;

public abstract class Task implements Runnable
{
	UUID uuid = UUID.randomUUID();
	EventBus bus;
	String name;

	public Task(final EventBus bus, final String name)
	{
		this.name = name;
		this.bus = bus;
	}

	public UUID getID()
	{
		return uuid;
	}

	public EventBus getBus()
	{
		return bus;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return uuid + ":" + name;
	}
}
