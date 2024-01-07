package com.lists.circularList;

public class CircularList<T>{

    private No<T> head;
    private No<T> tail;
    private int length;

    public CircularList() {
        this.tail = null;
        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public int size(){
        return this.length;
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia");

        if(index == 0)
            return this.tail;

        No<T> noHelp = this.tail;
        for(int i = 0; i < index;i++)
            noHelp = noHelp.getNoNext();

        return noHelp;
    }

    public T get(int index){
        return this.getNo(index).getContent();
    }

    public void add(T content){
        No<T> newNo = new No<>(content);
        if(this.isEmpty()){
            this.head = newNo;
            this.tail = this.head;
            this.head.setNoNext(this.tail);
        }else{
            newNo.setNoNext(this.tail);
            this.head.setNoNext(newNo);
            this.tail = newNo;
        }

        this.length++;
    }

    public void remove(int index){
        if(index >= this.length)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista");

        No<T> noHelp = this.tail;
        if(index == 0){
            this.tail = this.tail.getNoNext();
            this.head.setNoNext(this.tail);
        } else if(index == 1){
            this.tail.setNoNext(this.tail.getNoNext().getNoNext());
        }else{
            for(int i = 0;i < index-1;i++)
                noHelp = noHelp.getNoNext();

            noHelp.setNoNext(noHelp.getNoNext().getNoNext());
        }

        this.length--;
    }

    @Override
    public String toString() {
        String str = "";

        No<T> noHelp = this.tail;
        for(int i = 0; i < this.size();i++){
            str += "No[{content{"+noHelp.getContent()+"}]-->";
            noHelp = noHelp.getNoNext();
        }

        str += this.isEmpty() ? "()":"(Retorno ao inicio)";
        return str;
    }
}
