package com.concurrency.executorFramework;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        List<Future<BigInteger>> results = new ArrayList<>();

        // محاسبه فاکتوریل چند عدد
        for (int i = 20; i <= 25; i++) {
            results.add(calculator.calculateFactorial(i));
        }

        // گرفتن نتایج
        for (Future<BigInteger> result : results) {
            try {
                System.out.println("Result: " + result.get().toString().substring(0, 20) + "...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        calculator.shutdown();
    }
}
