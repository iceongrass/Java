import java.awt.*;
import java.io.*;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer {
	
	static JFrame f = new JFrame("My first Music Video");
	static MyDrawPanel ml;
	
	public static void main (String [] args)  {
		MiniMusicPlayer mini = new MiniMusicPlayer();
		mini.go();
	}
	
	public void go () {
		
		setGui();
		
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int [] eventIWant = {127};
			sequencer.addControllerEventListener(ml, eventIWant);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for (int i = 0; i < 80; i += 4) {
				//r = (int)((Math.random() * 50) + 1);
				r = i;
				track.add(makeEvent(144, 1, r, 44, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 44, i+2));
			} // end for
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(200);
			
			sequencer.start();
			
		} catch (Exception ex) {ex.printStackTrace();}
		
	} // end main
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		
		MidiEvent event = null;
		
		try {
			
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			
		} catch (Exception ex) {
			return event;
		}
		return event;
	} // end makeEvent()
	
	class MyDrawPanel extends JPanel implements ControllerEventListener {

		boolean msg = false;
		
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		} // end controlChange()
		
		public void paintComponent (Graphics g) {
			if (msg) {
				
				Graphics2D g2 = (Graphics2D) g;
				
				int r = (int) (Math.random() * 250);
				int gr= (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);
				
				g2.setColor(new Color(r, gr, b));
				
				int ht = (int)(Math.random() * 120 + 10);
				int wt = (int)(Math.random() * 120 + 10);
				int x  = (int)(Math.random() * 40 + 10);
				int y  = (int)(Math.random() * 40 + 10);
				g2.fillRect(x, y, wt, ht);
				msg = false;
			} // end if
		} // end paintComponent
		
	} // end class MyDrawPanel
	
	public void setGui() {
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	} //end setGui()
}