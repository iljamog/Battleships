import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

//GAME PANEL IS THE CONTAINER FOR OTHER PANELS aka THE SCREEN INSIDE THE WINDOW
public class GamePanel extends JPanel {

    private static final int DefaultHeight = 800;
    private static final int DefaultWidth = 1000;
    private static PlayerPanel playerPanel;
    public static EnemyPanel enemyPanel;
    public static GameInformationBar gameInfoBar;
    public static JButton button;
    private static GridBagConstraints gbc;
    public static GamePlay gamePlay;
    private JLabel endScreenText;
    private JPanel endScreen;
    

    // CONSTRUCTOR
    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setMinimumSize(new Dimension(DefaultWidth, DefaultHeight));
        this.setVisible(true);
        this.setBackground(Color.ORANGE.darker());

        // LAYOUT OF THE MAIN PANEL
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridwidth = 3;

        // ADDING PLAYER, ENEMY,INFO BOARD AND START BUTTON TO THE MAIN BOARD
        addEnemyPanel();
        addPlayerPanel();
        addGameInformationBar();        
        addButton();
        // BUTTON ACTION LISTENER
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource()==button) {
                    // IF PLAYER PRESSED START DISABLE START BUTTON AND HIS FIELD
                    button.setEnabled(false);                                        
                    playerPanel.DisableButtons();
                    button.setText("BATTLE HAS BEGUN");
                    gameInfoBar.setText("YOU HAVE THE FIRST MOVE, ATTACK ENEMY");

                    // GAMEPLAY INITIALIZED
                    gamePlay = new GamePlay();
                }
            }        
        });
    }
        // SETTING UP LOCATION OF PLAYER PANEL IN THE MAIN PANEL AND ADDING IT.
    public void addPlayerPanel(){
        playerPanel = new PlayerPanel();
        gbc.weightx=0.001;
        gbc.weighty=0.001;
        gbc.gridx= 1;
        gbc.gridy= 4;
        playerPanel.setBorder(BorderFactory.createTitledBorder("PLAYER"));
        this.add(playerPanel,gbc);
    }
        // SETTING UP LOCATION OF ENEMY PANEL IN THE MAIN PANEL AND ADDING IT.
    public void addEnemyPanel(){
        enemyPanel = new EnemyPanel();
        gbc.weightx=0.001;
        gbc.weighty=0.001;
        gbc.gridx= 1;
        gbc.gridy= 1;        
        enemyPanel.setBorder(BorderFactory.createTitledBorder("ENEMY"));
        this.add(enemyPanel,gbc);
    }
        // SETTING UP LOCATION OF GAME IFNO PANEL IN THE MAIN PANEL AND ADDING IT.
    public void addGameInformationBar(){
        gameInfoBar = new GameInformationBar();
        gbc.weightx=0.001;
        gbc.weighty=0.001;
        gbc.gridx= 1;
        gbc.gridy= 2;        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gameInfoBar.setBorder(BorderFactory.createTitledBorder("INFO"));
        this.add(gameInfoBar,gbc);
    }

    public void addButton(){
        button = new JButton("LEFT: 30");
        gbc.weightx=0.0001;
        gbc.weighty=0.0001;
        gbc.gridx= 1;
        gbc.gridy= 3;
        gbc.fill=GridBagConstraints.NONE;
        this.add(button,gbc);
        button.setEnabled(false);
    }

    // ADDING ENDSCREEN AND REMOVING EVERYTHING ELSE FROM MAIN PANEL
    public void addEndScreen(String whoWon){
        endScreen = new JPanel();
        endScreenText = new JLabel(whoWon,SwingConstants.CENTER);
        endScreen.setLayout(new FlowLayout());
        endScreen.setPreferredSize(new Dimension(DefaultWidth, DefaultHeight));
        endScreen.setMinimumSize(new Dimension(DefaultWidth, DefaultHeight)); 
        this.setBackground(Color.WHITE);       
        endScreen.setBackground(Color.WHITE);
        this.remove(button);
        this.remove(gameInfoBar);
        this.remove(enemyPanel);
        this.remove(playerPanel);        
        endScreenText.setFont(new Font("Helvetica", Font.BOLD, 30));
        endScreen.add(endScreenText);
        this.add(endScreen);
        this.revalidate();
    }
    
}