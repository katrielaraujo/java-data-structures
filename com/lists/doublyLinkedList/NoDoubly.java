package com.lists.doublyLinkedList;

public class NoDoubly<T>{

    private T content;
    private NoDoubly<T> next;
    private NoDoubly<T> previous;

    public NoDoubly(T content){
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public NoDoubly<T> getNext() {
        return next;
    }

    public void setNext(NoDoubly<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NoDoubly{" +
                "content=" + content +
                '}';
    }

    public NoDoubly<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NoDoubly<T> previous) {
        this.previous = previous;
    }
}
