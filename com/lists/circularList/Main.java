package com.lists.circularList;

public class Main {
    public static void main(String[] args) {
        CircularList<String> myList = new CircularList<>();

        myList.add("c0");
        System.out.println(myList);

        myList.remove(0);
        System.out.println(myList);

        myList.add("c2");
        myList.add("c3");
        myList.add("c4");
        System.out.println(myList);

        System.out.println(myList.get(4));
    }
}
