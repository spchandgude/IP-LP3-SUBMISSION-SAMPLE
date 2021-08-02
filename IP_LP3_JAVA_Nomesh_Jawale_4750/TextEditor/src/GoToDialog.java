import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoToDialog {

	JDialog Dialog = new JDialog(GUI.frame,"GOTO");
	JTextField textField = new JTextField();
	
	
	public GoToDialog() {
		
		int index;
		String button ="np";
		//frame = new JFrame();
		Dialog.setBounds(100, 100, 411, 216);
		//Dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dialog.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		Dialog.getContentPane().add(panel, "name_107031954747100");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Go TO");
		btnNewButton.setBounds(28, 97, 85, 21);
		
		panel.add(btnNewButton);
		
		//textField = new JTextField();
		textField.setBounds(28, 41, 278, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Line Number");
		lblNewLabel.setBounds(28, 21, 100, 13);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(149, 97, 85, 21);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(28, 70, 195, 13);
		lblNewLabel_1.setForeground(Color.RED);
		panel.add(lblNewLabel_1);
		
		Dialog.setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent arg0) {
				
				
					int i = Integer.parseInt(textField.getText()) - 1;
		
					int lines = GUI.textArea.getLineCount();
					
					
					try {
						
						 if(i <= 0) {
							System.out.println("out of index");
						}	
					
					if(lines > i)
					{
						GUI.textArea.setCaretPosition(GUI.textArea.getDocument().getDefaultRootElement()
	                        .getElement(i).getStartOffset());
						Dialog.dispose();
					}
					else {
						JOptionPane.showMessageDialog(Dialog,"Line number not found","Text Editor",JOptionPane.PLAIN_MESSAGE);
					}
					}
					catch(Exception e) {
						System.out.println(e);
					}

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent arg0) {
				
				Dialog.dispose();
			}
		});
		textField.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = textField.getText();
	            int l = value.length();

	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	               textField.setEditable(true);
	               lblNewLabel_1.setText("");
	            } else {
	               textField.setEditable(false);
	               lblNewLabel_1.setText("* Enter only numeric digits(0-9)");
	            }

	         }
	      });
		
		
	}// end of constructor
}// end of class
