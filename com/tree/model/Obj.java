package com.tree.model;

import java.util.Objects;

public class Obj implements Comparable<Obj> {

    Integer myValue;

    public Obj(Integer value) {
        this.myValue = value;
    }

    @Override
    public boolean equals(Object o) {
       if(this == o) return true;
       if(o == null || getClass() != o.getClass()) return false;
       Obj obj = (Obj)o;
       return Objects.equals(myValue, obj.myValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(myValue);
    }

    @Override
    public int compareTo(Obj other) {
        return Integer.compare(this.myValue, other.myValue);
    }

    @Override
    public String toString() {
        return myValue.toString();
    }
}
