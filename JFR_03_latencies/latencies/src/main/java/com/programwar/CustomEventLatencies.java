package com.programwar;
/**
 * Demonstrates how to create custom events.
 *
 * @author Marcus Hirt
 */
public class CustomEventLatencies {

	/**
	 * Main program entry.
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads;
		threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread(i, 30000000);
			threads[i].start();
		}
	}
}
