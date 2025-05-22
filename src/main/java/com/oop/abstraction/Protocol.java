package com.oop.abstraction;

public abstract class Protocol {
    protected String host;
    protected int port;

    public Protocol(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public abstract void connect();
    public abstract void sendData(String data);

    protected void log(String message) {
        System.out.println("Log: " + message);
    }
}

