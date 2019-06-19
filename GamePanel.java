import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    private Game game;
    private Timer timer = new Timer(50, this);
    private boolean gameActive;
    private LinkedList<String> moveQueue = new LinkedList<>();

    public GamePanel(Game game) {
    	this.game = game;
    	
        setBackground(Color.WHITE);
        snake = new Snake(game);
        
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        
        gameActive = true;
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
        repaint();
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
    	
    	//endGame();
        
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {

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
        if(!gameActive) {
            System.out.println("ending game");
            g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
        	g.drawString("GAME OVER", game.getWindowWidth() / 2 - 130, game.getWindowHeight() / 2);
        }
        //g.fillRect(0, 0, 100, 100);
        //g.fillRect(400, 400, 100, 100);
    }
}