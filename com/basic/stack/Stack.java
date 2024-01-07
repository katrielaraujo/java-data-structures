package com.basic.stack;

public class Stack {

    private No refNoEntrada;

    public Stack(){
        this.refNoEntrada = null;
    }

    public void push(No newNo){
        No refHelp = refNoEntrada; //Antigo topo
        refNoEntrada = newNo; // Novo topo
        refNoEntrada.setNo(refHelp); // Ajuste de posição
    }

    public No pop(){
        if(this.isEmpty())
            return null;

        No refHelp = refNoEntrada;
        refNoEntrada = refNoEntrada.getNo();
        return refHelp;
    }

    public No top(){
        return refNoEntrada;
    }

    public boolean isEmpty(){
        return refNoEntrada == null;
    }

    @Override
    public String toString() {
        String stringRetorno = "---------------\n";
        stringRetorno += "    Stack\n";
        stringRetorno += "---------------\n[";

        No noHelp = refNoEntrada;

        while(true){
            if(noHelp != null){
                stringRetorno += "No{dado="+ noHelp.getDado()+"}\n";
                noHelp = noHelp.getNo();
            }else{
                break;
            }
        }
        stringRetorno += "]---------------\n";

        return stringRetorno;
    }
}
