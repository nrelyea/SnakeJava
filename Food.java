import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {

    private Game game;
    private Point position;
    private Snake snake;

    public Food(Game game, Snake snake) {
        this.game = game;
        this.snake = snake;
        position = generateRandomPoint(game, snake);
        
    }
    
    public void spawnNewFood()
    {
    	position = generateRandomPoint(game, snake);
    }
    
    public Point generateRandomPoint(Game game, Snake snake) {
    	int randomX = 0, randomY = 0;
    	boolean validPosition = false;
    	
    	while(!validPosition) {
    		validPosition = true;
    		Random r = new Random();
        	randomX = r.nextInt(game.getGameWidth() / game.getSquareSize()) * game.getSquareSize();
        	randomY = r.nextInt(game.getGameWidth() / game.getSquareSize()) * game.getSquareSize();
        	//System.out.println(randomX + ", " + randomY);
        	
        	for(int i = 0; i < snake.getSnakeInfo().size(); i++) {
        		if(snake.getSnakeInfo().get(i).x == randomX && snake.getSnakeInfo().get(i).y == randomY) {
        			validPosition = false;
        		}
        	}
    	}    	    	
    	
    	return new Point(randomX, randomY);
    }
    
    public void update() {
    	   		    	
    }    
    

    public void paint(Graphics g) {
    	g.setColor(new Color(0,140,0));
    	g.fillRect(position.x, position.y, game.getSquareSize(), game.getSquareSize());
    }
    
    public Point getPosition() {
    	return position;
    }
    
}
