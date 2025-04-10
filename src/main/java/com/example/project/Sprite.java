package com.example.project;

public class Sprite {
    private int x, y;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int newX){
        x = newX;
    }

    public void setY(int newY){
        y = newY;
    }

    public String getCoords(){ // this method would return the coords 
        return "(" + x + "," + y + ")";
    }

    public String getRowCol(int size){ // this method would return the rows and cols also converting with cartesian plane
        int column = x;
        int row = size - y - 1;
        return "[" + row + "]" + "[" + column + "]";
    }

    public int getRow(int size) {
        return size - y - 1;
    }

    public int getColumn(int size) {
        return x;
    }

    public boolean isValid(int size, String direction){// This method is simalir and pretty much the same us the one in the sprite in its function if more information check the player class
        if (direction.equals("w")) {
            if (getY() == size - 1) {
                return false;
            } else {
                return true;
            }
        }
        if (direction.equals("a")) {
            if (getX() == 0) {
                return false;
            } else {
                return true;
            }
        }
        if (direction.equals("s")) {
            if (getY() == 0) {
                return false;
            } else {
                return true;
            }
        }
        if (direction.equals("d")) {
            if (getX() == size - 1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }
}