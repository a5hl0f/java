package com.company;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Position> storage;

    public Storage() {
        this.storage=new ArrayList<>();
    }
    public void add(Position newPosition){
        storage.add(newPosition);
    }

    public int size() {
        return storage.size();
    }

    public Position get(int i) {
       return storage.get(i);
    }

    public void clear() {
        storage.clear();
    }

    public void multiple(int choice) {
    int size=storage.size();
    for(int i=size-1;i>choice;i--){
        storage.remove(i);
    }
    }
}
