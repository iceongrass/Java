import java.awt.*;

import javax.swing.*;

public class MyDrawPanel extends JPanel {
	
	public void paintComponent1 (Graphics g) {
		
		g.setColor(Color.green);
		
		g.fillRect(20, 50, 100, 100);
		
	}
	
	public void paintComponent (Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColor = new Color(red, green, blue);
		
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColor = new Color(red, green, blue);
		
		GradientPaint gradient = new GradientPaint (100, 100, startColor, 200, 200, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(100, 100, 100, 100);
		
	}
	
}