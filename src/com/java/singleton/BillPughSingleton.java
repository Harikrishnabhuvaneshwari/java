package com.java.singleton;

// Thread Safe

public class BillPughSingleton {
    private BillPughSingleton() {
        // Still we can penetrate through Reflection API
    }

    private static class BillPughSingletonInner {
        public static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();

    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonInner.BILL_PUGH_SINGLETON;
    }
}
