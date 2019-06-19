import java.awt.Color;

import javax.swing.JFrame;

public class Game extends JFrame {
    private final static int WIDTH = 505, HEIGHT = 525;
    private final static int GAMEWIDTH = 500, GAMEHEIGHT = 500, SQUARESIZE = 25;
    
    private final static int gameSpeed = 75;
    
    private GamePanel panel;

    public Game() {
        setSize(WIDTH, HEIGHT);
        setTitle("Snake Boi");
        setBackground(Color.RED);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new GamePanel(this, gameSpeed);
        add(panel);
    }

    public GamePanel getPanel() {
        return panel;
    }
    
    public int getSquareSize() {
    	return SQUARESIZE;
    }
    
    public int getGameWidth() {
    	return GAMEWIDTH;
    }
    
    public int getGameHeight() {
    	return GAMEHEIGHT;
    }

    public static void main(String[] args) {
        new Game();
    }
}