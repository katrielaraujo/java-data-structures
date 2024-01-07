package com.lists.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("teste1");
        myList.add("teste2");
        myList.add("teste3");
        myList.add("teste4");

        System.out.println(myList.get(3));
        System.out.println(myList);
    }
}
