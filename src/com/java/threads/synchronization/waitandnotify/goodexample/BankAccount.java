package com.java.threads.synchronization.waitandnotify.goodexample;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amt) throws InterruptedException {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("debited");
        } else {
            System.out.println("Insufficient Funds");
            wait();
            withdraw(amt);
        }
    }

    public synchronized void deposit(int amt) {
        balance += amt;
        notify();
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);

        Runnable withdraw = () -> {
            try {
                bankAccount.withdraw(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable deposit = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bankAccount.deposit(100);
        };

        Thread thread1 = new Thread(withdraw);
        Thread thread2 = new Thread(withdraw);
        Thread thread3 = new Thread(deposit);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
