package com.programwar;

public class Logger {
    private static Logger myInstance = new Logger();

    public static Logger getLogger() {
        return myInstance;
    }

    public synchronized void log(String text) {
        try {
            Thread.sleep(20);
            System.out.println(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
