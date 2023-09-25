import javax.swing.*;
import java.awt.*;
import static SharedValues.SharedValues.*;

public class ScorePanel extends JPanel {
    JLabel score;
    public ScorePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,2*UNIT_SIZE));
        this.setBackground(new Color(0x9E6F99));
        this.setLayout(new BorderLayout());

        score = new JLabel("SCORE : " + applesEaten);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(new Font("Rockwell",Font.BOLD,40));
        score.setForeground(new Color(0xffe3f1));

        this.add(score,BorderLayout.CENTER);
    }
}
