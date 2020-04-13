public class Player {

    private int health;
    public char[] ships;

    public Player() {
        this.health = 20;
        shipsArea();
    }
    public void ReduceHealth(){
        this.health--;
        //ONCE HEALTH IS 0 OR BELOW END SCREEN APPEARS AND GAME IS STOPPED
        if (this.health<=0) {
            GameBoard.myGamePanel.addEndScreen("BAD LUCK, YOUR ENEMY HAS WON!");
        }
    }

    public void shipsArea(){
            /*
            2 x 4 squares
            3 x 3 squares
            4 x 2 squares
            5 x 1 squares  =  30
            */
        ships = new char[100];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = 'o';
        }
    }

    // TOTAL NR OF SHIPS FOR BUTTON FUNCTION
    public String shipsPlaced(){
        int total = 30;
        String totalString=  "LEFT: 30";
        for (char c : ships) {
            if (c == 'X') {
                total--;
                if (total==0) {
                    GamePanel.button.setEnabled(true);
                    totalString = "START";
                    
                }else{
                    GamePanel.button.setEnabled(false);   
                    totalString = Integer.toString(total);        
                    totalString = String.format("LEFT: %s", totalString);  
                }                
            }                  
        }
        return totalString;
    } // SHIPS PLACED ENDS
}