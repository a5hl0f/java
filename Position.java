package com.company;

public class Position {
    private int x,y,z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "("+x+","+y+","+z+")";
    }
}
