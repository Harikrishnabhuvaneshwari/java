package com.java.innerclass;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClass {

}

//Encapsulation
class Outer1 {
    class Inner1 {
        // Inner class code
    }
}

//Accessibility
class Outer2 {
    private int data;

    class Inner2 {
        void displayData() {
            System.out.println(data); // Inner class accessing private data of the outer class
        }
    }
}

//Composition
class Company {
    private String name;

    class Employee {
        // Inner class representing an employee of the company
    }
}

//Event Handling
class GUI1 {
    private JButton button;

    GUI1() {
        button = new JButton("Click Me");
        button.addActionListener(new ButtonListener()); // Inner class as an action listener
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Code to handle button click event
        }
    }
}

//Implementation of Iterators
class MyContainer<T> {
    private List<T> elements;

//    Iterator<T> getIterator() {
//        return new MyIterator(); // Inner class implementing iterator
//    }
//
//    class MyIterator implements Iterator<T> {
//        // Inner class implementing the iterator interface
//    }
}

//Anonymous inner class
class GUI2 {
    private JButton button;

    GUI2() {
        button = new JButton("Click Me");
        button.addActionListener(new ActionListener() { // Anonymous inner class as action listener
            public void actionPerformed(ActionEvent e) {
                // Code to handle button click event
            }
        });
    }
}

//Enhanced Readability
class Car {
    private String make;
    private String model;

    class Engine {
        // Inner class representing the car's engine
    }
}






