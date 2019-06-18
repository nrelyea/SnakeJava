import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Game game;
    private Snake snake;

    public GamePanel(Game game) {
        setBackground(Color.WHITE);
        this.game = game;
        snake = new Snake(game);
        Timer timer = new Timer(1000, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    private void update() {
        snake.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        snake.setDirection("up");
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.paint(g);
        //g.fillRect(0, 0, 100, 100);
        //g.fillRect(400, 400, 100, 100);
    }
}