import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Snake snake;
    private Food food;
    private Game game;
    private Timer timer;
    private boolean gameActive, winner;
    private LinkedList<String> moveQueue = new LinkedList<>();
    
    private int score;

    public GamePanel(Game game, int speed) {
    	this.game = game;
    	timer = new Timer(speed, this);
    	
        setBackground(Color.LIGHT_GRAY);
        snake = new Snake(game);
        
        food = new Food(game, snake);
        
        score = 0;
        
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        
        gameActive = true;
        winner = false;
    }

    private void update() {
    	
    	String newDirection = null;
    	if(!moveQueue.isEmpty()) {
    		newDirection = moveQueue.remove();
    	}
        snake.update(newDirection);
    }

    public void actionPerformed(ActionEvent e) {
        update();
        
        if(isOverlapping(snake.getSnakeInfo()) || snake.getSnakeInfo().get(0).x < 0 || snake.getSnakeInfo().get(0).x > game.getGameWidth() - game.getSquareSize() || snake.getSnakeInfo().get(0).y < 0 || snake.getSnakeInfo().get(0).y > game.getGameHeight() - game.getSquareSize()) {
    		endGame();
    	}
        
        if(snake.getSnakeInfo().get(0).x == food.getPosition().x && snake.getSnakeInfo().get(0).y == food.getPosition().y) {
        	System.out.println("yeet we ate that sheet");
        	snake.growTail();
        	food.spawnNewFood();
        	score += 1;
        	snake.setColor(new Color(0,140,0));
        }
        else {
        	snake.setColor(Color.BLACK);
        }     
        
        repaint();        
        
        if(snake.getSnakeInfo().size() >= ((game.getGameWidth() * game.getGameHeight()) / (game.getSquareSize() * game.getSquareSize())) - 1){
        	endGame();
        	winner = true;
        }
    }

    public void keyPressed(KeyEvent e) {
    	
        if((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && ((!moveQueue.isEmpty() && moveQueue.getLast() != "up" && moveQueue.getLast() != "down") || (moveQueue.isEmpty() && snake.getDirection() != "down"))) {
        	moveQueue.offer("up");        	
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) && ((!moveQueue.isEmpty() && moveQueue.getLast() != "down"  && moveQueue.getLast() != "up") ||(moveQueue.isEmpty() && snake.getDirection() != "up"))) {
        	moveQueue.offer("down");        	
        }
        else if((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && ((!moveQueue.isEmpty() && moveQueue.getLast() != "left"  && moveQueue.getLast() != "right") ||(moveQueue.isEmpty() && snake.getDirection() != "right"))) {
        	moveQueue.offer("left");        	
        }
        else if((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && ((!moveQueue.isEmpty() && moveQueue.getLast() != "right"  && moveQueue.getLast() != "left") ||(moveQueue.isEmpty() && snake.getDirection() != "left"))) {
        	moveQueue.offer("right");        	
        }
        
        if(!gameActive && e.getKeyCode() == KeyEvent.VK_R) {
        	Game newGame = new Game();
        }
        
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {

    }
    
    public boolean isOverlapping(List<Point> snake) {
    	int headX = snake.get(0).x;
    	int headY = snake.get(0).y;
    	for(int i = 2; i < snake.size(); i++) {
    		if(headX == snake.get(i).x && headY == snake.get(i).y) {
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    public void endGame() {
    	timer.stop();
        gameActive = false;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.paint(g);
        food.paint(g);
        if(gameActive) {
        	g.setFont(new Font("TimesRoman", Font.BOLD, 18));
        	g.drawString("Score: " + score, game.getGameWidth() / 2 - 40, 20);
        }
        else {
            System.out.println("ending game");
            g.setColor(Color.WHITE);
            g.fillRect(game.getGameWidth() / 2 - 130, game.getGameHeight() / 2 - 30, 252, 32);
            g.fillRect(game.getGameWidth() / 2 - 40, game.getGameHeight() / 2 + 25, 75, -25);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));   
            if(winner) {
            	g.drawString("YOU WON!", game.getGameWidth() / 2 - 130, game.getGameHeight() / 2);  
            }
            else {
            	g.drawString("GAME OVER", game.getGameWidth() / 2 - 130, game.getGameHeight() / 2);    
            }
                	
        	g.setFont(new Font("TimesRoman", Font.BOLD, 18));
        	g.drawString("Score: " + score, game.getGameWidth() / 2 - 40, game.getGameHeight() / 2 + 20);
        }
        //g.fillRect(0, 0, 100, 100);
        //g.fillRect(400, 400, 100, 100);
    }
}