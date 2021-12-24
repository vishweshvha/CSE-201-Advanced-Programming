package sample;

import java.util.ArrayList;

public class Objects <T>{                       //A generic class that is named as objects to store an array list
    private ArrayList <T> myList;

    public Objects() {
        this.myList = new ArrayList<T>();
    }

    public void add(T o) {
        this.myList.add(o);
    }

    public T get(int i) {
        return this.myList.get(i);
    }

    public void remove(T o){
        this.myList.remove(o);
    }

    public int getSize(){
        return this.myList.size();
    }
}
