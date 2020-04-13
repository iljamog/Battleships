import javax.swing.*;


// THE GAME WINDOW

public class GameBoard extends JFrame{

    public static GamePanel myGamePanel;

    public GameBoard(){
        //TITLE OF THE WINDOW AND INITIALIZING
        super("Battleships - THE GAME");
        myGamePanel = new GamePanel();        
        Start();
    }

    public void Start() {
        // MAKE THE WINDOW APPEAR AND STOP PROGRAMM ONCE WINDOW IS CLOSED
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ADDS THE MAIN CONTAINER PANEL INTO THE WINDOW aka GAMEpANEL
        buildGUI();
    }

    private void buildGUI(){
        // ADDS GAME PANEL TO THE WINDOW
        this.add(myGamePanel);
        //CROPS EVERYTHING TO FIT        
        pack();
    }
}