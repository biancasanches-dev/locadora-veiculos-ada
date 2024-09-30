package com.locadora.utils;

public class IdGenerator {
    private static IdGenerator instance;
    private long currentId;

    private IdGenerator() {
        this.currentId = 0;
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public synchronized long generateId() {
        return ++currentId;
    }
}
