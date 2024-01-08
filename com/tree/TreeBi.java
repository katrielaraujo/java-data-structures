package com.tree;

public class TreeBi<T extends Comparable<T>> {
    private NoBi<T> root;

    public TreeBi(){
        this.root = null;
    }

    public void insert(T value) {
        NoBi<T> noNew = new NoBi<>(value);
        root = insert(root,noNew);
    }

    private NoBi<T> insert(NoBi<T> current, NoBi<T> noNew) {
        if(current == null)
            return noNew;
        else if(noNew.getContent().compareTo(current.getContent()) < 0)
            current.setNoLeft(insert(current.getNoLeft(),noNew));
        else
            current.setNoRight(insert(current.getNoRight(),noNew));
        return current;
    }

    public void showInOrder(){
        System.out.printf("\n Exibindo InOrdem");
        showInOrder(this.root);
    }
    
    private void showInOrder(NoBi<T> current){
        if(current != null){
            showInOrder(current.getNoLeft());
            System.out.printf(current.getContent()+", ");
            showInOrder(current.getNoRight());
        }
    }
    
    public void showAfterOrder(){
        System.out.printf("\n Exibindo AfterOrdem");
        showAfterOrder(this.root);
    }
    
    private void showAfterOrder(NoBi<T> current){
        if(current != null){
            showAfterOrder(current.getNoLeft());
            showAfterOrder(current.getNoRight());
            System.out.printf(current.getContent()+", ");
        }
    }
    
    public void showPreOrder(){
        System.out.printf("\n Exibindo PreOrdem");
        showPreOrder(this.root);
    }
    
    private void showPreOrder(NoBi<T> current){
        if(current != null){
            System.out.printf(current.getContent()+", ");
            showPreOrder(current.getNoLeft());
            showPreOrder(current.getNoRight());
        }
    }

    public void remove(T value){
        try {
            NoBi<T> current = this.root;
            NoBi<T> dad = null;
            NoBi<T> son = null;
            NoBi<T> temp = null;

            while(current != null && !current.getContent().equals(value)){
                dad = current;
                if(value.compareTo(current.getContent()) < 0)
                    current = current.getNoLeft();
                else
                    current = current.getNoRight();
            }

            if(current == null)
                System.out.println("Conteudo nao encontrado. Bloco try");


            if(dad == null){
                if(current.getNoRight() == null){
                    this.root = current.getNoLeft();
                }else if(current.getNoLeft() == null){
                    this.root = current.getNoRight();
                }else{
                    for(temp = current, son = current.getNoLeft();
                    son.getNoRight() != null;
                    temp = son, son = son.getNoLeft()){
                        if(son != current.getNoLeft()){
                            temp.setNoRight(son.getNoLeft());
                            son.setNoLeft(root.getNoLeft());
                        }
                    }
                    son.setNoRight(root.getNoRight());
                    root = son;
                }
            }else if(current.getNoRight() == null){
                if(dad.getNoLeft() == current)
                    dad.setNoLeft(current.getNoLeft());
                else
                    dad.setNoRight(current.getNoLeft());
            }else if(current.getNoLeft() == null){
                if(dad.getNoLeft() == current)
                    dad.setNoLeft(current.getNoRight());
                else
                    dad.setNoRight(current.getNoRight());
            }else{
                for(
                    temp = current, son = current.getNoLeft();
                    son.getNoRight() != null;
                    temp = son, son = son.getNoRight()
                ){
                    if(son != current.getNoLeft()){
                        temp.setNoRight(son.getNoLeft());
                        son.setNoLeft(current.getNoLeft());
                    }
                    son.setNoRight(current.getNoRight());
                    if(dad.getNoLeft() == current)
                        dad.setNoLeft(son);
                    else
                        dad.setNoRight(son);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Conteudo nao encontrado");
        }
    }

    public NoBi<T> getNo(T value) {
        return getNo(root, value);
    }
    
    private NoBi<T> getNo(NoBi<T> current, T value) {
        if (current == null || current.getContent().equals(value)) {
            return current;
        }
    
        if (value.compareTo(current.getContent()) < 0) {
            return getNo(current.getNoLeft(), value);
        } else {
            return getNo(current.getNoRight(), value);
        }
    }
}
