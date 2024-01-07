package com.basic.stack;

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack();

        myStack.push(new No(1));
        myStack.push(new No(2));
        myStack.push(new No(3));
        myStack.push(new No(4));
        myStack.push(new No(5));
        myStack.push(new No(6));

        System.out.println(myStack);

        System.out.println(myStack.pop());

        System.out.println(myStack);

        myStack.push(new No(99));

        System.out.println(myStack);

        System.out.println(myStack.top());

    }
}
