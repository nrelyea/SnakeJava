import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Snake {
    private int squareSize;
    private Game game;
    private int x, y;
    private String direction;

    public Snake(Game game) {
        this.game = game;
        squareSize = game.getSquareSize();
        x = 0;
        y = 0;
        direction = "down";
    }

    public void update() {
        if(direction == "down") {
        	y += 50;
        }
    }
    
    public void setDirection(String dir) {
    	this.direction = dir;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, squareSize, squareSize);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, squareSize, squareSize);
    }
}