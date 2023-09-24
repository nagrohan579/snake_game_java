import javax.swing.*;
import java.awt.*;
import static SharedValues.SharedValues.*;

public class GamePanel extends JPanel {
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }
}
