import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Snake snake;
    private Game game;
    private Timer timer = new Timer(1000, this);
    private boolean gameActive;
    private List<String> moveList = new ArrayList<String>();

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
        snake.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    	
        if((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && ((!moveList.isEmpty() && moveList.get(moveList.size() - 1) != "up") || moveList.isEmpty())) {
        	moveList.add("up");        	
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) && ((!moveList.isEmpty() && moveList.get(moveList.size() - 1) != "down") || moveList.isEmpty())) {
        	moveList.add("down");
        }
        else if((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && ((!moveList.isEmpty() && moveList.get(moveList.size() - 1) != "right") || moveList.isEmpty())) {
        	moveList.add("right");
        }
        else if((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && ((!moveList.isEmpty() && moveList.get(moveList.size() - 1) != "left") || moveList.isEmpty())) {
        	moveList.add("left");
        }
      
        System.out.print("\nMove List: ");
    	for(int i = 0; i < moveList.size(); i++) {
    		System.out.print(moveList.get(i) + ", ");
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