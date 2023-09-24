import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(new GamePanel());
        this.setTitle("Snake Game");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}
