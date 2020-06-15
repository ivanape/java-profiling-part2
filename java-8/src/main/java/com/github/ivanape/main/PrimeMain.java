package com.github.ivanape.main;

import com.github.ivanape.common.DateHelper;
import com.github.ivanape.examples.PrimeNumbers;

public class PrimeMain {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000);
        Integer max = Integer.parseInt(args[0]);
        System.out.println(String.format("%s - starting the work with value: %d", DateHelper.now(), max));
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.generateNumbers(max);
        System.out.println(String.format("%s - All is done!", DateHelper.now()));
    }

}
