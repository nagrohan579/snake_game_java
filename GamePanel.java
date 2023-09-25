import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static SharedValues.SharedValues.*;

public class GamePanel extends JPanel implements ActionListener {
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    int appleX, appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    ScorePanel scorePanel;
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        startGame();
    }

    private void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
