package com.java.singleton;

import java.util.Objects;

// Not Synchronized - Not Thread Safe.
public class SimpleSingleton {

    private static SimpleSingleton SIMPLE_SINGLETON = null;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        if (Objects.isNull(SIMPLE_SINGLETON)){
            SIMPLE_SINGLETON = new SimpleSingleton();
        }
        return SIMPLE_SINGLETON;
    }

}
