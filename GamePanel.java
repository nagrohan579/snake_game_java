import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

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
    public GamePanel(ScorePanel scorePanel)
    {
        this.scorePanel = scorePanel;
        random = new Random();
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    private void draw(Graphics g)
    {
        if(running)
        {
            g.setColor(new Color(0x99FFE3F1, true));
            for (int i = 0; i < SCREEN_HEIGHT; i++) {
                g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
                g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
