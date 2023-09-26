import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        ScorePanel scorePanel = new ScorePanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(scorePanel,BorderLayout.NORTH);
        this.add(new GamePanel(scorePanel));
        this.setTitle("Snake Game");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}
