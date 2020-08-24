package com.programwar;

import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;

public class Hello {

    @Label("Hello World!")
    @Category("Custom Events")
    static class HelloWorldEvent extends Event {
        @Label("Message")
        String message;
    }

    public static void main(String... args) throws InterruptedException {
        Integer i = 0;
        while (true) {
            HelloWorldEvent event = new HelloWorldEvent();
            event.message = String.format("Hello World %d!", i);
            event.commit();
            i++;

            Thread.sleep(500);
        }

    }
}