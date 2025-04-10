package com.example.project;

//only needs a constructor
public class Treasure extends Sprite { //child of Sprite
    public Treasure(int x, int y) {
        super(x, y);
    }

    @Override 
    public String getCoords(){ // This method is going to return the Treasures coords
        return "Treasure:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){  // This method is going to return the treasures row and col
        return "Treasure:" + super.getRowCol(size);
    }
}