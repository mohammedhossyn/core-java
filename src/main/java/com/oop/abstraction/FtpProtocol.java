package com.oop.abstraction;

public class FtpProtocol extends Protocol {
    public FtpProtocol(String host, int port) {
        super(host, port);
    }

    @Override
    public void connect() {
        log("Connecting to FTP server at " + host + ":" + port);
    }

    @Override
    public void sendData(String data) {
        log("Sending FTP data: " + data);
    }
}
