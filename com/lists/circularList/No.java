package com.lists.circularList;

public class No<T> {

    private T content;
    private No<T> noNext;

    public No(T content){
        this.content = content;
        this.noNext = null;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public No<T> getNoNext() {
        return noNext;
    }

    @Override
    public String toString() {
        return "No{" +
                "content=" + content +
                '}';
    }

    public void setNoNext(No<T> noNext) {
        this.noNext = noNext;
    }
}
