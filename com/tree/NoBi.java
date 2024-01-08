package com.tree;

public class NoBi<T extends Comparable<T>>{
    
    private T content;
    private NoBi<T> noLeft;
    private NoBi<T> noRight;

    public NoBi(T content){
        this.content = content;
        noLeft = noRight = null;
    }

    public NoBi(){

    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public NoBi<T> getNoLeft() {
        return noLeft;
    }

    public void setNoLeft(NoBi<T> noLeft) {
        this.noLeft = noLeft;
    }

    public NoBi<T> getNoRight() {
        return noRight;
    }

    public void setNoRight(NoBi<T> noRight) {
        this.noRight = noRight;
    }

    @Override
    public String toString() {
        return "content{" +this.content + "}";
    }
}
