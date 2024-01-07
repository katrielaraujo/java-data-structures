package com.basic.queue;

public class Queue<T>{

    private No<T> refNoEntrada;

    public Queue(){
        this.refNoEntrada = null;
    }

    public void enqueue(T no){
        No newNo = new No(no);
        newNo.setRefNo(refNoEntrada);// a ponto para primeiro No
        refNoEntrada = newNo;
    }

    public T first(){
        if(this.isEmpty())
            return null;

        No noFirst = refNoEntrada;
        while (true){
            if(noFirst.getRefNo() != null) {
                noFirst = noFirst.getRefNo();
            }
            else {
                break;
            }
        }
        return (T) noFirst.getObject();
    }

    public Object dequeue(){
        if(this.isEmpty())
            return null;

        No noFirst = refNoEntrada;
        No noHelp = refNoEntrada;
        while (true){
            if(noFirst.getRefNo() != null){
                noHelp = noFirst;
                noFirst = noFirst.getRefNo();
            }else{
                noHelp.setRefNo(null);
                break;
            }
        }

        return (T) noFirst.getObject();
    }

    public boolean isEmpty(){
        return refNoEntrada == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Queue: ");
        No currentNode = refNoEntrada;

        while (currentNode != null) {
            result.append("[No{objeto=").append(currentNode.getObject()).append("}]");
            if (currentNode.getRefNo() != null) {
                result.append(" ----> ");
            }
            currentNode = currentNode.getRefNo();
        }

        if (isEmpty()) {
            result.append("null");
        }

        return result.toString();
    }
}
