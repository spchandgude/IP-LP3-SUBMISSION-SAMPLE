import java.awt.EventQueue;

import javax.swing.JFrame;

public class TextEditor {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = new GUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
