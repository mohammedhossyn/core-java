package com.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0) // فقط اعداد زوج
                .map(n -> n * 2)         // دو برابر کردن
                .collect(Collectors.toList()); // جمع‌آوری در لیست
    }

    public static void main1(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)   // فقط اعداد زوج: [4, 2, 6]
                .map(n -> n * 2)           // دو برابر: [8, 4, 12]
                .sorted()                  // مرتب‌سازی: [4, 8, 12]
                .reduce(0, Integer::sum);  // جمع: 24
        System.out.println(sum); // خروجی: 24
    }

    public static void main2(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                });
    }
    public static void main3(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // تعریف یک Stream با عملیات میانی
        Stream<Integer> stream = numbers.stream()
                           .filter(n -> {
                               System.out.println("Filtering: " + n);
                               return n % 2 == 0;
                           })
                           .map(n -> {
                               System.out.println("Mapping: " + n);
                               return n * 2;
                           });

        // هنوز هیچ چیزی چاپ نشده، چون عملیات نهایی فراخوانی نشده است
        System.out.println("Stream is created, but no process");

        // حالا عملیات نهایی فراخوانی می‌شود
        List<Integer> result = stream.collect(Collectors.toList());
        System.out.println(result);
    }

    public static void main4(String[] args) {
        Stream.generate(() -> 1)
                .limit(3) // فقط 3 عنصر بگیر
                .forEach(System.out::println); // خروجی: 1, 1, 1
    }
}