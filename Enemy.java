import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    private int health;
    public char[] ships;

    public Enemy() {
        this.health = 20;
        shipsArea();
        placeShips();
    }

    public void ReduceHealth(){
        this.health--;
        //ONCE HEALTH IS 0 OR BELOW END SCREEN APPEARS AND GAME IS STOPPED
        if (this.health<=0) {
            GameBoard.myGamePanel.addEndScreen("YOU HAVE WON THIS BATTLE!");
        }
    }

    public void shipsArea(){
        ships = new char[100];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = 'o';
        }
    }    

    public void placeShips(){
        boolean emptyCell = false;
        Random r = new Random();
        int counter=0;

        //UNUSABLE CELL INDEXES FOR VERTICAL SHIPS
        ArrayList<Integer> unusableHorizontal = new ArrayList<Integer>();        
        for (int i = 0; i < 10; i++) {
            int index1 = 7 + (10*counter);
            int index2 = 8 + (10*counter);
            int index3 = 9 + (10*counter);
            unusableHorizontal.add(index1);
            unusableHorizontal.add(index2);
            unusableHorizontal.add(index3);
            counter++;            
        }
        //USUSABLE CELL INDEXES FOR HORIZONTAL SHIPS
        ArrayList<Integer> unusableVertical = new ArrayList<Integer>();
        for (int i = 70; i < 100; i++) {
            unusableVertical.add(i);
        }
        //PLACING 2 4SQAURED SHIP
        for (int j = 1; j < 3; j++) { 
            while (!emptyCell) {
                counter = 10;                
                int usableCounter=0;
                int randomIndex = r.nextInt(100);
                // WITH RANDOM CHOOSE VERTICAL OR HORIZONTAL PLACEMENT
                if (r.nextInt(101) < 50) {                
                    if (!unusableHorizontal.contains(randomIndex)) { // Horizontal
                        //CHECK IF ALL 4 CELLS AVAILABLE
                        for(int i = 0; i < 4; i++){
                            if (ships[randomIndex+i] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF AVAILABLE PLACE THE SHIP
                        if (usableCounter==4) {
                            for (int i = 0; i < 4; i++) {
                                ships[randomIndex+i] = 'X';
                            }
                            emptyCell = true;
                        }
                    }
                }else{
                    if (!unusableVertical.contains(randomIndex)) {  // Vertical
                        //CHECKING IF 4 CELLS ARE AVAILABLE
                        for(int i = 0; i < 4; i++){
                            if (ships[randomIndex+(i*counter)] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF ALL 4 AVALAIBLE PLACE SHIP
                        if (usableCounter==4) {
                            for (int i = 0; i < 4; i++) {
                                ships[randomIndex+(i*counter)] = 'X';
                            }
                            emptyCell = true;
                        }                        
                    }
                }
            }
            emptyCell = false; // TO REPEAT WHILE LOOP FOR SECOND SHIP        
        }  // PLACING 4 SQAURED SHIPS ENDS

        // REMOVING SOME UNUSABLE INDEXES BEFORE PLACING SMALLER SHIPS
        for (int i = 0; i < 10; i++) { 
            unusableHorizontal.remove(0+(i*3)-(1*i));
        }
        for (int i = 0; i < 10;i++) {
            unusableVertical.remove(0);
        }
        // PLACING 3 x 3 SQUARE SHIPS
        for (int j = 1; j < 4; j++) { 
            while (!emptyCell) {
                counter = 10;                
                int usableCounter=0;
                int randomIndex = r.nextInt(100);
                // WITH RANDOM CHOOSE VERTICAL OR HORIZONTAL PLACEMENT
                if (r.nextInt(101) < 50) {                
                    if (!unusableHorizontal.contains(randomIndex)) { // Horizontal
                        //CHECK IF ALL 3 CELLS AVAILABLE
                        for(int i = 0; i < 3; i++){
                            if (ships[randomIndex+i] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF AVAILABLE PLACE THE SHIP
                        if (usableCounter==3) {
                            for (int i = 0; i < 3; i++) {
                                ships[randomIndex+i] = 'X';
                            }
                            emptyCell = true;
                        }
                    }
                }else{
                    if (!unusableVertical.contains(randomIndex)) {  // Vertical
                        //CHECKING IF 3 CELLS ARE AVAILABLE
                        for(int i = 0; i < 3; i++){
                            if (ships[randomIndex+(i*counter)] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF ALL 3 AVALAIBLE PLACE SHIP
                        if (usableCounter==3) {
                            for (int i = 0; i < 3; i++) {
                                ships[randomIndex+(i*counter)] = 'X';
                            }
                            emptyCell = true;
                        }                        
                    }
                }
            }
            emptyCell = false; // TO REPEAT WHILE LOOP FOR SECOND SHIP        
        } // PLACING 3 SQUARED SHIPS ENDS

        // 2 SQUARE SHIPS START
        // REMOVING SOME UNUSABLE INDEXES BEFORE PLACING SMALLER SHIPS
        for (int i = 0; i < 10; i++) { 
            unusableHorizontal.remove(0+(i*2)-(i*1));
        }
        for (int i = 0; i < 10; i++) { 
            unusableVertical.remove(0);
        }
        // PLACING 4 x 2 SQUARE SHIPS
        for (int j = 1; j < 5; j++) { 
            while (!emptyCell) {
                counter = 10;                
                int usableCounter=0;
                int randomIndex = r.nextInt(100);
                // WITH RANDOM CHOOSE VERTICAL OR HORIZONTAL PLACEMENT
                if (r.nextInt(101) < 50) {                
                    if (!unusableHorizontal.contains(randomIndex)) { // Horizontal
                        //CHECK IF ALL BOTH CELLS AVAILABLE
                        for(int i = 0; i < 2; i++){
                            if (ships[randomIndex+i] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF AVAILABLE PLACE THE SHIP
                        if (usableCounter==2) {
                            for (int i = 0; i < 2; i++) {
                                ships[randomIndex+i] = 'X';
                            }
                            emptyCell = true;
                        }
                    }
                }else{
                    if (!unusableVertical.contains(randomIndex)) {  // Vertical
                        //CHECKING IF BOTH CELLS ARE AVAILABLE
                        for(int i = 0; i < 2; i++){
                            if (ships[randomIndex+(i*counter)] == 'o') {
                                usableCounter++;
                            }
                        }
                        // IF ALL 2 AVALAIBLE PLACE SHIP
                        if (usableCounter==2) {
                            for (int i = 0; i < 2; i++) {
                                ships[randomIndex+(i*counter)] = 'X';
                            }
                            emptyCell = true;
                        }                        
                    }
                }
            }
            emptyCell = false; // TO REPEAT WHILE LOOP FOR SECOND SHIP        
        } // PLACING 2 SQUARED SHIPS ENDS

        // CLERING ARRAYS WITH UNUSABLE INDEXES
        unusableHorizontal.clear();
        unusableVertical.clear();
        //PLACING 5 x  1 SQAURED SHIPS
        for (int j = 1; j < 6; j++) { 
            while (!emptyCell) {
                counter = 10;
                int randomIndex = r.nextInt(100);

                //CHECK IF THE CELL AVAILABLE
                // IF AVAILABLE PLACE THE SHIP
                if (ships[randomIndex] == 'o') {
                    ships[randomIndex] = 'X';
                    emptyCell = true;
                    }
                }
            emptyCell = false; 
        }
    } //PLACING SHIPS ENDS

}