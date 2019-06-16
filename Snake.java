import java.applet.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Applet implements KeyListener{
	
	public void init() {
		this.addKeyListener(this);		
	}
	
	public void paint(Graphics g) {
		setSize(500, 500);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(new Rectangle(0,0,50,50));
		g2d.fill(new Rectangle(450,450,50,50));
	}

	public void keyPressed(KeyEvent arg0) {
		System.out.println("YEET");
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}