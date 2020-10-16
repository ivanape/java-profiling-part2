package com.programwar;

public class WorkerThread extends Thread {

    private int loopCount;
    private int id;

    public WorkerThread(int id, int loopCount) {
        super("Worker Thread " + id);
        this.loopCount = loopCount;
        this.id = id;
    }

    public void run() {
        while (true) {
            for (int i = 0; i < loopCount; i++) {

            }
            Logger.getLogger().log("Work done Thread" + this.id);

            Thread.yield();
        }

    }
}
