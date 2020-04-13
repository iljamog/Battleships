import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GamePlay {

    

    // ARRAYS WITH INDEXES FOR ENEMY AI
    List<Integer> topBorderIndexes;
    List<Integer> bottomBorderIndexes;
    List<Integer> leftBorderIndexes;
    List<Integer> rightBorderIndexes;
    ArrayList<Integer> usedIndexes;
    Random r;


    public GamePlay(){        
        // ENABLE ENEMY SCREEN FOR CLICKS
        GamePanel.enemyPanel.EnableEnemyScreen();
        
        //FOR AI
        r = new Random();
        usedIndexes = new ArrayList<Integer>();

        // FILL ARRAYS WITH INDEXES FOR ENEMY AI USE
        this.topBorderIndexes= Arrays.asList(1,2,3,4,5,6,7,8);
        this.bottomBorderIndexes= Arrays.asList(91,92,93,94,95,96,97,98);
        this.leftBorderIndexes= Arrays.asList(10,20,30,40,50,60,70,80);
        this.rightBorderIndexes = Arrays.asList(19,29,39,49,59,69,79,89);
        
    }

    public void PlayerMove(int index){
        if (EnemyPanel.enemy.ships[index]=='X') {
            EnemyPanel.buttons[index].setBackground(Color.RED);
            EnemyPanel.buttons[index].setEnabled(false);
            GamePanel.gameInfoBar.setText("ENEMY WAS HIT, KEEP SHOOTING!");
            EnemyPanel.enemy.ReduceHealth();  
        }else{
            GamePanel.gameInfoBar.setText("YOU MISSED AND ENEMY DID A COUNTER ATTACK");
            EnemyPanel.buttons[index].setBackground(Color.BLACK);
            EnemyPanel.buttons[index].setEnabled(false);
            // ENEMY MOVE INITIALIZATION
            EnemyMove();
        }
    } // PLAYER MOVE ENDS
    
    public void EnemyMove(){
        int index = r.nextInt(100);
        if (usedIndexes.contains(index)) {
            while (usedIndexes.contains(index)) {
                index = r.nextInt(100);
            }
        }       

        if (PlayerPanel.player.ships[index]=='X') {
            PlayerPanel.buttons[index].setBackground(Color.RED.darker());
            usedIndexes.add(index);
            PlayerPanel.player.ReduceHealth();
            EnemyMove(index);             
        }else{            
            PlayerPanel.buttons[index].setBackground(Color.BLACK);
            usedIndexes.add(index);
        }
    } // ENEMY MOVE ENDS

    // OVERLOADED PLAYERMOVE IF HE HIT A TARGET
    public void EnemyMove(int index){
        // IF BOT HIT A CELL IN CORNERS
        if (index == 0) { // NORTH WEST CORNER
            int decision = r.nextInt(2);
            if (decision==0 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT CELL
                index++;
            } else if(decision==1 && !usedIndexes.contains(index+10)){ // SHOOTS BOTTOM CELL
                index=index+10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }                
            }
        } else if (index == 9) { // NORTH EAST CORNER
            int decision = r.nextInt(2);
            if (decision==0 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT CELL
                index--;
            } else if (decision==1 && !usedIndexes.contains(index+10)){ // SHOOTS BOTTOM CELL
                index=index+10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        }else if (index == 90) { // SOUTH WEST CORNER
            int decision = r.nextInt(2);
            if (decision==0 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT CELL
                index++;
            } else if (decision==1 && !usedIndexes.contains(index-10)) { // SHOOTS CELL ABOVE
                index=index-10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        }else if (index == 99) {
            int decision = r.nextInt(2);
            if (decision==0 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT CELL
                index--;
            } else if (decision==1 && !usedIndexes.contains(index-10)) {  // SHOOTS CELL ABOVE
                index=index-10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        // IF BOT HIT A CELL ON THE EDGE
        } else if(topBorderIndexes.contains(index)){
            int decision = r.nextInt(3);
            if (decision==0 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT
                index--;
            } else if(decision==1 && !usedIndexes.contains(index+10)) { // SHOOTS BELOW
                index=index+10;
            } else if(decision==2 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT                
                index++;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        } else if(bottomBorderIndexes.contains(index)){
            int decision = r.nextInt(3);
            if (decision==0 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT
                index--;
            } else if(decision==1 && !usedIndexes.contains(index-10)) { // SHOOTS ABOVE
                index=index-10;
            } else if(decision==2 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT      
                index++;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        }else if(leftBorderIndexes.contains(index)){
            int decision = r.nextInt(3);
            if(decision==0 && !usedIndexes.contains(index-10)) { // SHOOTS ABOVE
                index=index-10;
            } else if(decision==1 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT      
                index++;
            } else if(decision==2 && !usedIndexes.contains(index+10)) { // SHOOTS BELOW
                index=index+10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        }else if(rightBorderIndexes.contains(index)){
            int decision = r.nextInt(3);
            if(decision==0 && !usedIndexes.contains(index-10)) { // SHOOTS ABOVE
                index=index-10;
            } else if (decision==1 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT
                index--;
            } else if(decision==2 && !usedIndexes.contains(index+10)) { // SHOOTS BELOW
                index=index+10;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }
        } else { // IF BOT CHOSE TO SHOOT CELLS IN THE MIDDLE
            int decision = r.nextInt(4);
            if(decision==0 && !usedIndexes.contains(index-10)) { // SHOOTS ABOVE
                index=index-10;
            } else if (decision==1 && !usedIndexes.contains(index-1)) { // SHOOTS LEFT
                index--;
            } else if(decision==2 && !usedIndexes.contains(index+10)) { // SHOOTS BELOW
                index=index+10;
            } else if(decision==3 && !usedIndexes.contains(index+1)) { // SHOOTS RIGHT      
                index++;
            } else {
                if (usedIndexes.contains(index)) {
                    while (usedIndexes.contains(index)) {
                        index = r.nextInt(100);
                    }
                }  
            }            
        }

        if (PlayerPanel.player.ships[index]=='X') {
            PlayerPanel.buttons[index].setBackground(Color.RED.darker());
            usedIndexes.add(index);
            PlayerPanel.player.ReduceHealth();
            EnemyMove(index);
        }else{            
            PlayerPanel.buttons[index].setBackground(Color.BLACK);
            usedIndexes.add(index);
        }

    }  // OVERLOADED PLAYERMOVE ENDS
    


    
}