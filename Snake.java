import java.applet.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends Applet implements KeyListener{
	
	private Rectangle rect;
	
	public void init() {
		this.addKeyListener(this);
		
		rect = new Rectangle(0,0,50,50);
	}
	
	public void paint(Graphics g) {
		setSize(500, 500);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(rect);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("YEET");
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}