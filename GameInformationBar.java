import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.*;

// MESSAGE BAR TO GUIDE THE PLAYER

public class GameInformationBar extends JLabel{

    public GameInformationBar(){
        super();
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        this.setText(" START PLACING SHIPS WHEN READY! ");

        //FONT SETTINGS
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Helvetica", Font.BOLD, 30));
    }
}