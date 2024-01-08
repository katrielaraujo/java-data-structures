package com.tree;

import com.tree.model.Obj;

public class Main {
    public static void main(String[] args) {
        TreeBi<Obj> myTree = new TreeBi<>();

        myTree.insert(new Obj(13));
        myTree.insert(new Obj(10));
        myTree.insert(new Obj(25));
        myTree.insert(new Obj(2));
        myTree.insert(new Obj(12));
        myTree.insert(new Obj(20));
        myTree.insert(new Obj(31));
        myTree.insert(new Obj(29));
        myTree.insert(new Obj(32));

        System.out.println("InOrdem:");
        myTree.showInOrder();

        System.out.println("\nAfterOrdem:");
        myTree.showAfterOrder();

        System.out.println("\nPreOrdem:");
        myTree.showPreOrder();
        System.out.println();
    }
}
