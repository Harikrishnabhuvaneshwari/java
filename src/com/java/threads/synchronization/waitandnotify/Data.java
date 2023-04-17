package com.java.threads.synchronization.waitandnotify;

public class Data {
    private String message;

    public void send(String message) {
        this.message = message;
    }

    public String receive() {
        return message;
    }
}