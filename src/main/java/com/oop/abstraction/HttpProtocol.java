package com.oop.abstraction;

public class HttpProtocol extends Protocol {
    public HttpProtocol(String host, int port) {
        super(host, port);
    }

    @Override
    public void connect() {
        log("Connecting to HTTP server at " + host + ":" + port);
    }

    @Override
    public void sendData(String data) {
        log("Sending HTTP request: " + data);
    }
}
