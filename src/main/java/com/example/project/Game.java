package com.example.project;

import java.util.Scanner;
// This class is vital in the function of the game and we see how it sets the game up
public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size;


    public Game(int size){  // In this method it would set up the grid and than call initialize and play which are coded below
        this.size = size;
        grid = new Grid(size);
        initialize(); 
        play(); 
    }


    public static void clearScreen() { 
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void play(){ 
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;
        
        while(keepPlaying && player.getLives() > 0 && !player.getWin()){ // This method is long so first you would have to see if the condtions 
                                                             //for the user are true first if they want to play and than if the lives and wins are vaild
            clearScreen();
            grid.display();
            System.out.println("Player:" + player.getCoords()); // these print statments are printing what the current display is and the state of it 
            System.out.println("Player:" + player.getRowCol(size));
            System.out.println("Treasure Collected: " + player.getTreasureCount() + "/" + treasures.length);
            System.out.println("Lives remaining: " + player.getLives());
            
            System.out.print("Enter a direction (w, a, s, d) or 'q' to exit: "); // now the user is asking what they would like to do
                                                                                  // and depending on their choice the game would behvae different
            String move = scanner.nextLine().toLowerCase(); // this makes sure that the users input is lowercase  to avoid human error
            
            if(move.equals("q")){
                keepPlaying = false;
            } else {
                boolean isValidInput = move.matches("[wasd]"); // these booleans statments make sure the vaildity of the code is true
                boolean isValidMove = isValidInput && player.isValid(size, move);
                
                if(!isValidInput){ // so now if it is not vaild because of the input meaning user error the user would be aksed to pick wasd
                    System.out.println("Invalid input! Use w, a, s, or d.");
            } else if(!isValidMove){
                    System.out.println("Can't move that direction!"); // this would mean the user can not move that way and would be forced to pick another direction
                }
            
            if(isValidInput && isValidMove){ // so now if the input and move is true meaning it is vaild it would get the new postions of the player
                int newX = player.getX();
                int newY = player.getY();
                    
       if(move.equals("a")){ // this group of if else statments are just changing the x and y of the player depending on the input 
       newX--;
       } else if(move.equals("d")){
           newX++;
       } else if(move.equals("w")){
           newY++;
       } else if(move.equals("s")){
               newY--;
           }
                    
       int row = size - newY - 1;
       int col = newX;
       Sprite target = grid.getGrid()[row][col];
                    
     if(target instanceof Trophy && player.getTreasureCount() != treasures.length){ // so now it is going to check if the user has interactwd with trophy and 
                                                                                     //if they have do they have enough treasure    
              System.out.println("You need all treasures first!"); // this is what would be printed if they do not have enough treasure 
                 } else {
            player.interact(size, move, treasures.length, target);  // the following 3 lines are handling the interact and move 
             player.move(move);
              grid.placeSprite(player, move);
                        
               if(player.getWin()){   // so now it is going to check if the player got the win so it would clear screen and call the win method 
                                     //for when the user wins and this would mean the user is no longer playing 
                 clearScreen();
                  grid.win();
                   keepPlaying = false;
                   } else if(player.getLives() <= 0){ // now it checks if the user has enough lives  and it clears the screen and calls the game over method 
                     clearScreen();
                     int playerRow = player.getRow(size);
                    int playerCol = player.getColumn(size);
                       grid.gameover(playerRow, playerCol);
                       keepPlaying = false;
                        }
                    }
                }
                // and this is going to pause to show the messages
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }


    // this method is going to initialize the grid and the things in it 
    public void initialize(){
        player = new Player(0, 0);
        trophy = new Trophy(size-1, size-1); // this place the player at the bottom left cornor and the trophy on the top right corner 
        
        treasures = new Treasure[2];  // this places the treasures at fixed loctions 
        treasures[0] = new Treasure(2, 2);
        treasures[1] = new Treasure(5, 7);
        
        
        enemies = new Enemy[2];    // this place the enemies at fixed loction 
        enemies[0] = new Enemy(3, 5);
        enemies[1] = new Enemy(6, 2);
      
        // now this is placing all the objects on the grid 
        grid.placeSprite(player);
        grid.placeSprite(trophy);
        for(Treasure t : treasures){
            grid.placeSprite(t);
        }
        for(Enemy e : enemies){
            grid.placeSprite(e);
        }
    }


    public static void main(String[] args) {
        Game game = new Game(10); // this method is now going to start the game with a 10x10
    }
}