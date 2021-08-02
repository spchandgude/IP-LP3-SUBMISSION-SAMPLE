import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NewOperation extends GUI {

	public void ConfirmDialog() throws IOException
	{
	String strMsg="Do you want to save the changes?";
	
	int x=JOptionPane.showConfirmDialog(frame,strMsg,Name,JOptionPane.YES_NO_CANCEL_OPTION);

	if(x==JOptionPane.CANCEL_OPTION) 
	{
	}
	
	if(x==JOptionPane.YES_OPTION )
	{
		System.out.println("in save");
		String value = textArea.getText();
		SaveOperation s = new SaveOperation();
		FileWriter fw;
		
			try {
				fw = new FileWriter(defaultPath);
				fw.close();
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//GUI.textArea.setText("");
			
		
		frame.dispose();
	}
	if(x == JOptionPane.NO_OPTION)
	{
		try {
			FileWriter fw = new FileWriter(defaultPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		frame.dispose();
		GUI.textArea.setText("");
	}
	}

	
	
	public NewOperation() {
		try {
			
			if(changedPath == defaultPath && textArea.getText() != "")
			{
				SaveOperation save =new SaveOperation();
				FileWriter fw = new FileWriter(GUI.defaultPath);
			}
			else if(textArea.getText() == "" ) {
				textArea.setText("");
			}
			else
			{
				
				ConfirmDialog();
	
			}
		}
		catch(Exception e) {System.out.println(e);}
		
	}// end of constructor 

}// end of class
