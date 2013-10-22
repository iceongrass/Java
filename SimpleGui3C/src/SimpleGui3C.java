import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {
	
	JFrame frame;
	
	public static void main (String [] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
	
	public void go() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setSize(300, 300);
		
		JButton button = new JButton("change color");
		//button.setName("change color");
		button.addActionListener(this);
		
		MyDrawPanel panel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		// TODO Auto-generated method stub
		frame.repaint();
	}
	
}