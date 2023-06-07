package com.java.lambdaexp;


/**
why the surrounding scope code variable(or) local variable, when used inside an
anonymous inner class(or)lambda expression must be declared final or effectively final?


Note : Leaving this class in compilation error state for better understanding.
*/

public class EffectivelyFinal {

    public static void main(String[] args) {
        /*
        This should be final or effectively final. since we used this variable inside an
        anonymousInnerClass(or maybe even in lambda), this variable belongs to the CLOSURE.

        CLOSURE concept here in java is used to maintain consistency, reliability and reduce error.
        (Keep in mind, today in java you can pass functions and classes as an argument. We need trust, someone
        has to monitor the states of variables used inside these funcs and args, there comes the CLOSURE)

        But how? CLOSURE means encapsulating or capturing the state of a variable inside the
        container(in this case lets imagine our lambdaExp or anonymous class as that container).
        This will ensure that the variables are always monitored and leads to improved consistency, reliability,
        reduced error code etc.

        Closure Vs. Lambda
        Java lambda expression is a way to define a function inline rather than the standard method of declaration.
        It provides a concise way to represent a function.
        While closure is a function that encompasses its surrounding state by referencing fields that are external to its body.
        Note that both are functions but not all closures are lambdas and not all lambdas are closures.

        The difference between closure and lambda is quite equivalent to the distinction between a class and an instance of the class.
        A class exists only in source code. it doesn't exist at runtime. What exists at runtime are objects of the class type.
        Closures are to lambdas as objects are to classes.

        That's why java compiler is asking you to make that variable explicitly final (or) if you're not making it
        then I(compiler) will consider it as effectively final and will keep monitoring you for the changes.

        After all CLOSURES are everywhere from maths to js to python to AI! But java closures are bit diff!

        Wrap Up!

         */
        int a = 1;
        int b = 2; // this is effectively final in this case. we used this inside lambdaExp.
        a = 3;

        // legacy - anonymous way.
        Printer anonymousInnerClass = new Printer() {
            @Override
            public void print(int i) {
                /*
                 compilation error, because we changed the value of a after initializing.
                 Note : compiler monitors(closure) you.
                 */
                System.out.println(i + a);
            }
        };

        // functional style - lambda expression.
        Printer lambdaExp = i -> System.out.println(i + b);

        finalPrint(anonymousInnerClass, a); // o/p:2
        finalPrint(lambdaExp, b); // o/p:4
    }

    static void finalPrint(Printer printer, int i) {
        printer.print(i);
    }
}

interface Printer {
    void print(int i);
}
