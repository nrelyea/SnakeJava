import java.applet.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Snake extends Applet implements KeyListener{
	
	int width;
	int height;
	int squareSize;
	
	boolean gameOver;
	
	Point headPoint;
	
	Graphics bufferGraphics;
	Image offscreen;
	
	long currentTime;
	
	
	public Snake() {
		
		width = 500;
		height = 500;
		squareSize = 50;
		
		gameOver = false;
		
		headPoint = new Point(0,0);	
		
		offscreen = createImage(width,height);
		bufferGraphics = offscreen.getGraphics();
		
		this.addKeyListener(this);
				
			
	}
	
	public void start() {
		currentTime = System.currentTimeMillis();
		
//		Timer time = new Timer(1000, this);
//		time.start();
////		while(!gameOver) {
////			
////		}
//		
//		time.stop();
//		currentTime = System.currentTimeMillis() - currentTime;
//		repaint();
		
		
		Timer timer = new Timer();
		timer.schedule(new SayHello(), 0, 5000);
	}
	
	public void paint(Graphics g) {
		bufferGraphics.clearRect(0,0,width,height);
		bufferGraphics.fillRect(headPoint.x,headPoint.y,squareSize,squareSize);
		
		g.drawImage(offscreen, 0, 0, this);
		Toolkit.getDefaultToolkit();
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if(headPoint.x < 450) {
				headPoint = new Point(headPoint.x + 50, headPoint.y);
			}
			repaint();
			break;		
		case KeyEvent.VK_LEFT:
			if(headPoint.x > 0) {
				headPoint = new Point(headPoint.x - 50, headPoint.y);
			}
			repaint();
			break;
		case KeyEvent.VK_UP:
			System.out.println("UP");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			break;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

class SayHello extends TimerTask {
    public void run() {
       System.out.println("Hello World!"); 
    }
}

