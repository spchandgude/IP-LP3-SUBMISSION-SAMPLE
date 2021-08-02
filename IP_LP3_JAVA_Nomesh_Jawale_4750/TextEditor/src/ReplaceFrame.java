import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceFrame {

	private JFrame frame =  new JFrame();
	private JTextField findText = new JTextField();
	private JTextField replaceText = new JTextField();



	// Create the application.
	String find = findText.getText();
	Pattern p = Pattern.compile(find);
	String textField = GUI.textArea.getText();
	Matcher m = p.matcher(textField);
	 
	public ReplaceFrame() {
		
		frame.setVisible(true);

		frame.setBounds(100, 100, 586, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel findLabel = new JLabel("Find :");
		findLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findLabel.setBounds(35, 49, 52, 27);
		frame.getContentPane().add(findLabel);
		
		findText = new JTextField();
		findText.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findText.setBounds(111, 55, 239, 19);
		frame.getContentPane().add(findText);
		findText.setColumns(10);
		
		JButton findNextButton = new JButton("Find Next");
		findNextButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		findNextButton.setBounds(402, 54, 85, 21);
		frame.getContentPane().add(findNextButton);
		
		JLabel replaceLabel = new JLabel("Replace :");
		replaceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		replaceLabel.setBounds(35, 132, 70, 27);
		frame.getContentPane().add(replaceLabel);
		
		replaceText = new JTextField();
		replaceText.setFont(new Font("SansSerif", Font.PLAIN, 14));
		replaceText.setText("");
		replaceText.setBounds(111, 138, 239, 19);
		frame.getContentPane().add(replaceText);
		replaceText.setColumns(10);
		
		JButton replaceButton = new JButton("Replace");
		replaceButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		replaceButton.setBounds(402, 137, 85, 21);
		frame.getContentPane().add(replaceButton);
		
		JButton replaceAllButton = new JButton("Replace All");
		replaceAllButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		replaceAllButton.setBounds(402, 214, 85, 21);
		frame.getContentPane().add(replaceAllButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cancelButton.setBounds(402, 285, 85, 21);
		frame.getContentPane().add(cancelButton);
		
		findText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(findText.getText() == null)
				{
					findNextButton.setVisible(false);
				}
			}
		});
		
		frame.setVisible(true);
		int i ,j;
		
		if(findText.getText() == null)
		{
			findNextButton.setVisible(false);
			replaceButton.setVisible(false);
			replaceAllButton.setVisible(false);
			
		}
		else {
			findNextButton.setVisible(true);
			replaceButton.setVisible(true);
			replaceAllButton.setVisible(true);
		}
		findNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FIND NEXT
				String value = findText.getText();
				GUI.context = GUI.textArea.getText();
				
				int result[] = ReusableFunctions.findOperation(value);
				System.out.println("values are = "+result[0]+"..."+result[1]);
				GUI.textArea.select(result[0],result[1]);
			}
		});
		
		replaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REPLACE
				
				String replaceValue =  replaceText.getText();
				GUI.textArea.replaceRange(replaceValue, GUI.firstIndex, GUI.lastIndex);
				
			}
		});
		
		
		replaceAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//REPLACE ALL

				
				String s1 = GUI.textArea.getText();
				String replace = s1.replaceAll(findText.getText(),replaceText.getText());
				System.out.println(replace);
				GUI.textArea.setText(replace);
				
				
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//REPLACE ALL

				
				frame.dispose();
				
				
			}
		});
	}

}
