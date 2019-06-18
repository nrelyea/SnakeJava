import java.awt.Color;

import javax.swing.JFrame;

public class Game extends JFrame {
    private final static int WIDTH = 505, HEIGHT = 525, SQUARESIZE = 50;
    private GamePanel panel;

    public Game() {
        setSize(WIDTH, HEIGHT);
        setTitle("Snake Boi");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new GamePanel(this);
        add(panel);
    }

    public GamePanel getPanel() {
        return panel;
    }
    
    public int getSquareSize() {
    	return SQUARESIZE;
    }

    public static void main(String[] args) {
        new Game();
    }
}