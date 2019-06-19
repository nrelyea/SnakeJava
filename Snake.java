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
        x = squareSize * 10;
        y = squareSize * 10;
        direction = "right";
    }

    public void update(String newDirection) {
    	//System.out.println("X: " + (x / squareSize) + " Y: " + (y / squareSize));    	   	
    	
    	System.out.println("newDirection: ");
    	
    	if(newDirection != null) {
    		direction = newDirection;    		
    	}
    	switch(direction) {
        case "up":
        	y -= squareSize;
        	break;
        case "down":
        	y += squareSize;
        	break;
        case "left":
        	x -= squareSize;
        	break;
        case "right":
        	x += squareSize;
        	break;        
        }
    }
    
    public void setDirection(String dir) {
    	this.direction = dir;
    }
    
    public String getDirection() {
    	return direction;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, squareSize, squareSize);
    }
}