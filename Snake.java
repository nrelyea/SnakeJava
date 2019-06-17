import java.applet.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Applet implements KeyListener{
	
	Point headPoint;
	
	
	public void init() {
		//Thread t = new Thread(this);
		
		
		
		
		this.addKeyListener(this);
				
		headPoint = new Point(0,0);		
	}
	
	public void run() {
		System.out.println("yeet");
	}
	
	public void paint(Graphics g) {
		setSize(500, 500);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(new Rectangle(headPoint.x,headPoint.y,50,50));
		
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