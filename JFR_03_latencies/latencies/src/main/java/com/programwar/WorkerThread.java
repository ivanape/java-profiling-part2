package com.programwar;

public class WorkerThread extends Thread {
	public final static Logger LOGGER = Logger.getLogger();

	private int loopCount;

	public WorkerThread(int id, int loopCount) {
		super("Worker Thread " + id);
		this.loopCount = loopCount;
	}

	public void run() {
		while (true) {
			WorkEvent event = new WorkEvent(CustomEventLatencies.WORK_EVENT_TOKEN);
			event.begin();
			int x = 1;
			int y = 1;
			for (int i = 1; i < loopCount; i++) {
				x += 1;
				y = y % (this.loopCount + 3);
				if (x % (this.loopCount + 4) == 0 || y == 0) {
					System.out.println("Should not happen");
				}
			}
			event.end();
			event.commit();
			LOGGER.log("Thread reporting work done");
			Thread.yield();
		}
		
	}
}
