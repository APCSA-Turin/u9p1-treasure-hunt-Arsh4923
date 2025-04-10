package com.example.project;

//Dot only needs a constructor
public class Dot extends Sprite {
    public Dot(int x, int y) {
        super(x, y);
    }

    @Override 
    public String getCoords(){ //This method is going to return the dot and the coords
        return "Dot:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){ //This method is going to return the return the dots row and cols
        return "Dot:" + super.getRowCol(size);
    }
}