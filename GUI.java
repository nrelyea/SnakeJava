import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame{
	// private JPanel mainPanel;
	private JLabel statusbar;
	private GraphicsPanel mainPanel = new GraphicsPanel();
	
	public GUI() {
		super("title");
		
		initComponents();
	}
	
	private void initComponents() {
		//GraphicsPanel mainPanel = new GraphicsPanel();
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel, BorderLayout.CENTER);
		
		statusbar = new JLabel("default");
		add(statusbar, BorderLayout.SOUTH);
	}

	class GraphicsPanel extends JPanel {

		GraphicsPanel() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(420,420));
        }

        @Override
        public void paintComponent(Graphics g) {
        	Graphics2D g2d = (Graphics2D) g;
    		super.paintComponent(g2d);
    		g2d.setStroke(new BasicStroke(2));
    		
    		g2d.setFont(new Font("Tahoma", Font.PLAIN, 24));
    		g2d.drawString("YEET", 50, 50);

        }
        
        
    }
}