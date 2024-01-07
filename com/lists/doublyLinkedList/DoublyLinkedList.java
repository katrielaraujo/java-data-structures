package com.lists.doublyLinkedList;

public class DoublyLinkedList<T> {

    private NoDoubly<T> noFirst;
    private NoDoubly<T> noLast;
    private int lengthList = 0;

    public DoublyLinkedList() {
        noFirst = null;
        noLast = null;
        this.lengthList = 0;
    }

    public int size() {
        return lengthList;
    }

    public void add(int index, T item) {
        NoDoubly<T> noHelp = getNo(index);
        NoDoubly<T> newNo = new NoDoubly<>(item);
        newNo.setNext(noHelp);

        if (newNo.getNext() != null) {
            newNo.setPrevious(noHelp.getPrevious());
            newNo.getNext().setPrevious(newNo);
        } else {
            newNo.setPrevious(noLast);
            noLast = newNo;
        }

        if (index == 0) {
            noFirst = newNo;
            if (newNo.getNext() != null) {
                noLast = newNo.getNext();
            }
        } else {
            newNo.getPrevious().setNext(newNo);
        }

        lengthList++;
    }

    public void add(T item) {
        NoDoubly<T> newNo = new NoDoubly<>(item);
        newNo.setNext(null);
        newNo.setPrevious(noLast);

        if (noFirst == null) {
            noFirst = newNo;
        }

        if (noLast != null) {
            noLast.setNext(newNo);
        }

        noLast = newNo;
        lengthList++;
    }

    public void remove(int index) {
        if (index < 0 || index >= lengthList) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }

        if (index == 0) {
            noFirst = noFirst.getNext();
            if (noFirst != null) {
                noFirst.setPrevious(null);
            }

            if (noFirst == null) {
                noLast = null;
            }
        } else {
            NoDoubly<T> noHelp = getNo(index);
            noHelp.getPrevious().setNext(noHelp.getNext());

            if (noHelp.getNext() != null) {
                noHelp.getNext().setPrevious(noHelp.getPrevious());
            } else {
                noLast = noHelp.getPrevious();
            }
        }

        lengthList--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        NoDoubly<T> noHelp = noFirst;

        for (int i = 0; i < lengthList; i++) {
            str.append("[No{conteudo=").append(noHelp.getContent()).append("}]-->");
            noHelp = noHelp.getNext();
        }

        return str.toString() + "null";
    }

    public T get(int index) {
        return getNo(index).getContent();
    }

    private NoDoubly<T> getNo(int index) {
        checkLimit(index);
        NoDoubly<T> noHelp = noFirst;

        for (int i = 0; i < index; i++) {
            noHelp = noHelp.getNext();
        }

        return noHelp;
    }

    public void checkLimit(int index) {
        if (index < 0 || index >= lengthList) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
    }
}
