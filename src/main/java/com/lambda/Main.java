package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream()
                .filter(n -> n % 2 == 0) // لامبدا: شرط برای انتخاب اعداد زوج
                .map(n -> n * 2)         // لامبدا: دو برابر کردن
                .forEach(System.out::println); // خروجی: 4, 8

    }

    public static void main1(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };
    }

    public static void main2(String[] args) {
        new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 2;
            }
        };
    }

    public static void main3(String[] args) {
        List<Integer> numbs = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = numbs.stream()
                .filter(n -> n % 2 == 0) // لامبدا 1
                .map(n -> n * 2)         // لامبدا 2
                .collect(Collectors.toList());
    }

    public static void main4(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        String results = nums.stream()
                .filter(n -> n % 2 == 0)         // لامبدا: Predicate
                .map(n -> "Number: " + n)        // لامبدا: Function
                .collect(Collectors.joining(", ")); // جمع‌آوری به رشته
        System.out.println(results); // خروجی: Number: 2, Number: 4
    }

    private static Integer lambda$0(Integer n) {
        return n * 2;
    }
}
