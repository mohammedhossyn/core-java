package com.oop.abstraction;

public class Main {
    public static void main(String[] args) {
        Protocol http = new HttpProtocol("example.com", 80);
        Protocol ftp = new FtpProtocol("ftp.example.com", 21);

        http.connect();
        http.sendData("GET /index.html");
        ftp.connect();
        ftp.sendData("STOR file.txt");
    }
}
