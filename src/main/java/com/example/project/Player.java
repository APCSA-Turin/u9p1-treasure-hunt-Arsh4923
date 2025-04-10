
package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite  {
    private int treasureCount;
    private int numLives;
    private boolean win;


    public Player(int x, int y) { //This method is basically going to set the player up and sets everything as it should be at the start of the game where the user has 0 treasure 2 lives and no win
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        win = false;
    }

    public int getTreasureCount(){
        return treasureCount;
    }
   
    public int getLives() {
        return numLives;
    }



    public boolean getWin(){
        return win;
    }


    @Override
    public String getCoords(){ // This method would return the coords of the player
        return "Player:" + super.getCoords();
    }


    @Override
    public String getRowCol(int size){ // This method would return the row and cols of the player
        return "Player:" + super.getRowCol(size);
    }
   
    @Override
    // this method is going to move the coords of the player so when the user inputs a wasd value 
    //the direction would change depeding on that input this method is key for moving the player to treasure and winning the game
    public void move(String direction) { //move the (x,y) coordinates of the player
            if (direction.equals("w")) {
                setY(getY() + 1);
            }
            if (direction.equals("s")) {
                setY(getY() - 1);
            }
            if (direction.equals("a")) {
                setX(getX() - 1);
            }
            if (direction.equals("d")) {
                setX(getX() + 1);
            }
        }


    public void interact(int size, String direction, int numTreasures, Object obj) { 
        // This method is basically decding how the action of the player will interact with the features around the player
        if(isValid(size,direction)){
            if(obj instanceof Enemy){
                numLives--;    
            } else if (obj instanceof Treasure){
                if(obj instanceof Trophy){
                    if(treasureCount==numTreasures){  
                        win = true;
                    }
                } else {
                    treasureCount++;    
                }
            }
        }
    }
   
     //This method is going to check if the direction the user decides to go is vaild meaning that they cant pick direction where you cant go any futher
     // an example of how this method would work is that you are on the edge of a cornor 
     // and want to below when there is no more grid for you to go this method will helpn decide if that is vaild
      public boolean isValid(int size, String direction) { 
        if (direction.equals("w")) {
            if (super.getY() + 1 > size - 1) { // this is basically checking if the user inout is value all of these if else statments are
                                               // just checking if the diretion the user is going has a direction to go to 
                return false;
            }
        } else if (direction.equals("a")) {
            if (super.getX() - 1 < 0) {
                return false;
            }
        } else if (direction.equals("s")) {
            if (super.getY() - 1 < 0) {
                return false;
            }
        } else if (direction.equals("d")) {
            if (super.getX() + 1 > size - 1) {
                return false;
            }
        }
        return true;
    }
}