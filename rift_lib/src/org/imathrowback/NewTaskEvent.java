package org.imathrowback;

public class NewTaskEvent
{
	Task task;

	public NewTaskEvent(final Task task)
	{
		this.task = task;
	}

	public Task getTask()
	{
		return task;
	}

}
