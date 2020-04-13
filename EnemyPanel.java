import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// PLAYER BOARD, ADDED TO THE GAME PANEL

public class EnemyPanel extends JPanel implements ActionListener{

    private static final int DefaultHeight=300;    
    private static final int DefaultWidth=300;
    public static JButton[] buttons;
    public static Enemy enemy;
    public static int enemyButtonIndex;

    public EnemyPanel() {
        // SIZE AND LAYOUT
        super();
        this.setPreferredSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setMinimumSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(10,10));
        //FILLING WITH BUTTONS
        FillWithButtons();
        // ADDING A ENEMY
        enemy = new Enemy();
    }

    public void FillWithButtons() {
        buttons = new JButton[100];
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setSize(new Dimension(25,25));
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setEnabled(false);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
    }

    public void EnableEnemyScreen(){
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }

    // ENEMY BUTTON ACTION LISTENER

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < 100; i++) {
            if (buttons[i] == ae.getSource()) {
                enemyButtonIndex = i;
                GamePanel.gamePlay.PlayerMove(enemyButtonIndex);
            }
        }
    }
}
