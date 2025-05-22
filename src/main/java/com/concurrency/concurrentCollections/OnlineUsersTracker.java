package com.concurrency.concurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class OnlineUsersTracker {
    private final ConcurrentHashMap<String, Integer> userVisits = new ConcurrentHashMap<>();

    public void recordVisit(String userId) {
        userVisits.compute(userId, (key, value) -> value == null ? 1 : value + 1);
        System.out.println(Thread.currentThread().getName() + " recorded visit for " + userId);
    }

    public int getVisitCount(String userId) {
        return userVisits.getOrDefault(userId, 0);
    }

}