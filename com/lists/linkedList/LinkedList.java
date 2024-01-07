package com.lists.linkedList;

public class LinkedList<T> {
    No<T> refInput;

    public LinkedList() {
        this.refInput = new No<>();
    }

    public Integer size(){
        Integer ListSize = 0;
        No<T> refHelp = refInput;

        while(refHelp != null){
            refHelp = refHelp.getNextNo();
            ListSize++;
        }

        return ListSize;
    }

    public void add(T no){
      No<T> newNo = new No<>(no);

      if(this.isEmpty()){
          refInput = newNo;
          return;
      }

      No<T> refHelp = refInput;
      for(int i = 0; i < this.size()-1;i++)
          refHelp = refHelp.getNextNo();

      refHelp.setNextNo(newNo);
    }

    public T get(int index){
        return getNo(index).getContent();
    }

    public T remove(int index){
        No<T>  noPivor = this.getNo(index);

        if(index == 0)
            refInput = noPivor.getNextNo();
        else{
            No<T>  noPrevius = this.getNo(index-1);
            noPrevius.setNextNo(noPivor.getNextNo());
        }

        return (T) noPivor.getContent();
    }

    @Override
    public String toString() {
        String str = "[";
        No<T> noHelp = refInput;
        for(int i = 0; i < this.size();i++){
            str += "No{conteudo="+ noHelp.getContent() +"} --->";
            noHelp = noHelp.getNextNo();
        }
        str += "null]";
        return str;
    }

    private No<T> getNo(int index){
        checkLimit(index);
        No<T> refHelp = refInput;
        for(int i = 0; i <= index;i++)
            refHelp = refHelp.getNextNo();

        return refHelp;
    }

    public void checkLimit(int index){
        if(index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException("Índex fora dos limites da lista");
    }

    public boolean isEmpty(){
        return refInput == null;
    }
}
