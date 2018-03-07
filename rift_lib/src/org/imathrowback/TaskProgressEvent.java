package org.imathrowback;

public class TaskProgressEvent
{
	Task task;
	long progress;
	long total;

	public TaskProgressEvent(final Task task, final long progress, final long total)
	{
		this.task = task;
		this.progress = progress;
		this.total = total;
	}

	public Task getTask()
	{
		return task;
	}

	public long getProgress()
	{
		return progress;
	}

}
