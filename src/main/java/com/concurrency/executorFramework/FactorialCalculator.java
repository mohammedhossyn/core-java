package com.concurrency.executorFramework;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;

public class FactorialCalculator {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public Future<BigInteger> calculateFactorial(int number) {
        return executor.submit(() -> {
            BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + " calculated factorial of " + number);
            return result;
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}