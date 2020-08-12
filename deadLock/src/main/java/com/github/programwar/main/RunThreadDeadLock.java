package com.github.programwar.main;

public class RunThreadDeadLock {

    private static class LeftRightDeadLock implements Runnable {
        private static final Object left = new Object();
        private static final Object right = new Object();

        public void doSomething() {
            char[] tmp = new char[1024 * 1024];
            tmp[1] = 'a';
            System.out.printf("doSomething %s%n", Thread.currentThread().getName());
        }

        public void leftRight() {
            synchronized (left) {
                synchronized (right) {
                    System.out.printf("%s -> leftRight calling doSomething%n", Thread.currentThread().getName());
                    doSomething();
                }
            }
        }

        public void rightLeft() {
            synchronized (right) {
                synchronized (left) {
                    System.out.printf("%s -> rightLeft calling doSomething%n", Thread.currentThread().getName());
                    doSomething();
                }
            }
        }

        public void run() {
            System.out.printf("%s -> run%n", Thread.currentThread().getName());

            try {
                while (true) {
                    leftRight();
                    rightLeft();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.flush();
            }
        }

    }

    public static void main(String[] args) {
        LeftRightDeadLock first = new LeftRightDeadLock();
        LeftRightDeadLock second = new LeftRightDeadLock();
        LeftRightDeadLock third = new LeftRightDeadLock();

        Thread tFirst = new Thread(first);
        tFirst.setName("tFirst");
        Thread tSecond = new Thread(second);
        tSecond.setName("tSecond");
        Thread tThird = new Thread(third);
        tThird.setName("tThird");

        tFirst.start();
        tSecond.start();
        tThird.start();
    }

}