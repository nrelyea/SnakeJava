import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import javax.swing.JOptionPane;

public class Snake {
    private int squareSize;
    private Game game;
    private String direction;
    private List<Point> snake = new ArrayList<Point>();

    public Snake(Game game) {
        this.game = game;
        squareSize = game.getSquareSize();
        direction = "right";
        snake.add(new Point(squareSize * 10, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 25, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 50, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 75, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 100, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 125, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 150, squareSize * 10));
        snake.add(new Point(squareSize * 10 - 175, squareSize * 10));
    }

    public void update(String newDirection) {
    	
    	if(newDirection != null) {
    		direction = newDirection;    		
    	}
    	
    	int headX = snake.get(0).x;
    	int headY = snake.get(0).y;
    	
    	switch(direction) {
        case "up":
        	snake.add(0, new Point(headX, headY - squareSize));
        	break;
        case "down":
        	snake.add(0, new Point(headX, headY + squareSize));
        	break;
        case "left":
        	snake.add(0, new Point(headX - squareSize, headY));
        	break;
        case "right":
        	snake.add(0, new Point(headX + squareSize, headY));
        	break;        
        }
    	
    	snake.remove(snake.size() - 1);    	    	
    }    
    
    public void setDirection(String dir) {
    	this.direction = dir;
    }
    
    public String getDirection() {
    	return direction;
    }
    
    public List<Point> getSnakeInfo(){
    	return snake;
    }

    public void paint(Graphics g) {
    	for(int i = 0; i < snake.size(); i++) {
    		g.fillRect(snake.get(i).x, snake.get(i).y, squareSize, squareSize);
    	}
        
    }
}