import java.awt.Color;
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
    private Point prevTail;
    private Color snakeColor;

    public Snake(Game game) {
        this.game = game;
        squareSize = game.getSquareSize();
        direction = "right";
        snake.add(new Point(squareSize * 3, squareSize));
        snake.add(new Point(squareSize * 3 - squareSize, squareSize));
        snake.add(new Point(squareSize * 3 - (squareSize * 2), squareSize));
        
        snakeColor = Color.BLACK;
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
    	
    	prevTail = snake.get(snake.size() - 1);
    	snake.remove(snake.size() - 1);    	    	
    }   
    
    public void growTail() {
    	snake.add(prevTail);
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
    
    public void setColor(Color clr) {
    	snakeColor = clr;
    }

    public void paint(Graphics g) {
    	g.setColor(Color.DARK_GRAY);
    	g.fillRect(snake.get(0).x, snake.get(0).y, squareSize, squareSize);
    	g.setColor(snakeColor);
    	for(int i = 1; i < snake.size(); i++) {
    		g.fillRect(snake.get(i).x, snake.get(i).y, squareSize, squareSize);
    	}
        
    }
}