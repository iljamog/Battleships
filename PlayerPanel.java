import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// PLAYER BOARD, ADDED TO THE GAME PANEL
public class PlayerPanel extends JPanel implements ActionListener{

    private static final int DefaultHeight=300;    
    private static final int DefaultWidth=300;
    public static JButton[] buttons;
    public static Player player;    

    public PlayerPanel() {        
        // SIZE AND LAYOUT
        super();
        this.setPreferredSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setMinimumSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(10,10));
        //FILLING WITH BUTTONS
        FillWithButtons();
        //CREATING A PLAYER
        player = new Player();
    }

    public void FillWithButtons() {
        buttons = new JButton[100];
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setSize(new Dimension(25,25));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            this.add(buttons[i]);
        }
    }

    public void DisableButtons(){
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    // IF BUTTONS ON PLAYER PANEL ARE PRESSED ( ACTION LISTENER INTERFACE METHOD)
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 100; i++) {
            if (buttons[i] == ae.getSource()) {
                GamePanel.gameInfoBar.setText("4 □ x 2 / 3 □ x 3 / 2 □ x 4 / 1 □ x 5");
                // CHANGES COLOR OF CLICKED CELL AND SEND INFO INTO PLAYERS SHIP ARRAY, ADDED UNDO OPTIONS VIA CLICKING AGAIN            
                Color bgOfButton = buttons[i].getBackground();
                if(bgOfButton == Color.LIGHT_GRAY){
                    buttons[i].setBackground(Color.GREEN.darker());
                    player.ships[i] = 'X';
                } else {
                    buttons[i].setBackground(Color.LIGHT_GRAY);
                    player.ships[i] = 'o';
                }

                // DISPLAYING NUMBER OF PLAYER PLACED SHIPS ON BUTTON , ONCE 30 PLAYER CAN START THE GAME
                GamePanel.button.setText(player.shipsPlaced());
            }
        }
    } // ACTIONLISTENER END
}