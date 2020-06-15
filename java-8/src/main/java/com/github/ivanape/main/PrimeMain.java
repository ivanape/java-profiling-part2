package com.github.ivanape.main;

import com.github.ivanape.examples.PrimeNumbers;

public class PrimeMain {

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Integer max = Integer.parseInt(args[0]);
        primeNumbers.generateNumbers(max);
    }

}
