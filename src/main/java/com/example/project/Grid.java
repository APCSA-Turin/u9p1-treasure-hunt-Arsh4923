package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { // This method would create the grid and than place the dots in the grid 
        this.size = size;
        grid = new Sprite[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Dot(col, size - 1 - row);
            }
        } 
    }

    public int getSize() {
        return size;
    }

    public Sprite[][] getGrid(){
        return grid;
    }

    public void placeSprite(Sprite s){ //place sprite in new spot
      int row = s.getRow(size);
      int col = s.getColumn(size); 
      grid[row][col] = s;
    }

    public void placeSprite(Sprite s, String direction) { //This methods is going place sprite in a new spot based on direction and 
        //it would need the old coords before  the mogement to replace it with the Dot sprrite
        
        int prevX = s.getX();
        int prevY = s.getY();
        if (direction.equals("s")){
            prevY++;
        }else if (direction.equals("a")){
            prevX++;
        }else if (direction.equals("d")){
            prevX--;
        }else if (direction.equals("w")){
            prevY--;
        }
        placeSprite(new Dot(prevX, prevY)); // This would removes the old sprite and replaces with DOT sprite
        placeSprite(s);
    }



    public void display() { // The method as its name implies is going to display the grid and what the current grid is 
      for(int i = 0; i < grid.length; i++){
         for(int j = 0; j < grid[0].length; j++){ // The function of this is bascially that if there is an instance of something 
                                                    //it is than prints what should be displayed for that instance 
            if(grid[i][j] instanceof Enemy){
                System.out.print("👹");
             }else if(grid[i][j] instanceof Player){
                  System.out.print("🦄 ");
             }else if(grid[i][j] instanceof Dot){
                System.out.print("⬜");
             }else if(grid[i][j] instanceof Treasure &&  !(grid[i][j] instanceof Trophy)){
                System.out.print("💵");
            }else if(grid[i][j] instanceof Trophy){
                 System.out.print("🏆");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(int r, int c){ //The method is used when the user has reached zero lives meaning they have failed to collect the treasure 
       
        System.out.println("You lose, truly sad think about your mistakes ");
    }

    public void win(){ //This method would be used when the user has won after collecting the treasures and having lives greater than 0
       
        System.out.println("You win you might almost be as great as LeBron, im joking you could never be that great ");
    }
}
