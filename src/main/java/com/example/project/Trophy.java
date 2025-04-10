package com.example.project;

// only needs a constructor
public class Trophy extends Treasure { //child of treasure
    public Trophy(int x, int y){
        super(x, y);
    }

    @Override 
    public String getCoords(){ // The method is going to return the trophies coords
        return "Trophy:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){ // This method is going to return the trophies row and col loction
        return "Trophy:" + super.getRowCol(size);
    }
}
