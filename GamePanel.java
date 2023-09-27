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

//            Display the apple on the screen
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

//            Display the snake on the screen
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' ->
                    y[0] -= UNIT_SIZE;
            case 'D' ->
                    y[0] += UNIT_SIZE;
            case 'L' ->
                    x[0] -= UNIT_SIZE;
            case 'R' ->
                    x[0] += UNIT_SIZE;
        }
    }

    private void checkCollisons() {
        //        check if head touches left border
        if (x[0] < 0) {
            running = false;
        }

//        check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }

//        check if head touches top border
        if (y[0] < 0) {
            running = false;
        }

//        check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollisons();
        }
        repaint();
    }
}
