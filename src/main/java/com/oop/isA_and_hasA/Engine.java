package com.oop.isA_and_hasA;

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println(type + " engine is starting");
    }
}

