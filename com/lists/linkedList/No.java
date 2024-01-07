package com.lists.linkedList;

public class No<T> {
    private T content;
    private No<T> nextNo;

    public No(){
        this.nextNo = null;
    }

    public No(T content) {
        this.nextNo = null;
        this.content = content;
    }

    public No(T content, No nextNo) {
        this.content = content;
        this.nextNo = nextNo;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + content +
                '}';
    }

    public No getNextNo() {
        return nextNo;
    }

    public void setNextNo(No nextNo) {
        this.nextNo = nextNo;
    }
}
