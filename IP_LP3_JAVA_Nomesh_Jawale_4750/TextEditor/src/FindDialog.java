import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class FindDialog {
		
		JFrame frame = new JFrame();
		static JTextField findText = new JTextField();
		JDialog d = new JDialog(GUI.frame, "find");

		String find = findText.getText();
		Pattern p = Pattern.compile(find);
		String textField = GUI.textArea.getText();
		Matcher m = p.matcher(textField);

	public FindDialog() {
	
		frame.setVisible(true);
		frame.setBounds(100, 100, 446, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel findLabel = new JLabel("Find : ");
		findLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findLabel.setBounds(26, 73, 45, 13);
		frame.getContentPane().add(findLabel);
		
		
		findText.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findText.setBounds(92, 70, 243, 19);
		frame.getContentPane().add(findText);
		findText.setColumns(10);
		
		JButton findNextButton = new JButton("Find Next");
		findNextButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findNextButton.setBounds(81, 134, 85, 21);
		frame.getContentPane().add(findNextButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cancelButton.setBounds(257, 134, 85, 21);
		frame.getContentPane().add(cancelButton);
		
		findNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = findText.getText();
				GUI.context = GUI.textArea.getText();
				
				int result[] = ReusableFunctions.findOperation(value);
				System.out.println("values are = "+result[0]+"..."+result[1]);
				GUI.textArea.select(result[0],result[1]);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.reset();
				GUI.lastIndex = 0;
				frame.dispose();
			}
		});
	}
}
