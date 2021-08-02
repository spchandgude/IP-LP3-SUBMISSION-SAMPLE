import java.awt.Dialog;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.regex.*;

public class ReusableFunctions extends GUI{
	
	static JDialog d =new JDialog();

	
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(x == JOptionPane.NO_OPTION)
		{
			FileWriter fw = new FileWriter(defaultPath);
			GUI.textArea.setText("");
		}
		
		
	}
	
	public static int[] findOperation(String value) {
		
		String textField = GUI.textArea.getText();
		System.out.println("value="+value);

		if (value == "") { 
			JOptionPane.showMessageDialog(d,"Please enter something","Text Editor",JOptionPane.PLAIN_MESSAGE);
			return new int[] {0,0};
		}
		else {
			//demo.FindValue = value;
			String findV = FindDialog.findText.getText();
			Pattern p = Pattern.compile(value);
			Matcher m = p.matcher(textField);
			Matcher m1 = p.matcher(textField);
			
			System.out.println();
		//	int lastInd = textField.lastIndexOf(find);
					
			if(m.find(GUI.lastIndex) ) {
				
					System.out.println("error = "+(m.find(GUI.lastIndex) ));
					GUI.lastIndex = m.end();
			
					
					System.out.println(m.start()+"..."+m.end()+"..."+m.group());
					
					System.out.println(GUI.lastIndex);
					
//					if(GUI.flag == false)
//						break;
//					else
//						break;
								
			
					
					return new int[] {m.start(),m.end()};
			}
			else {

				JOptionPane.showMessageDialog(d,"No more record found","Text Editor",JOptionPane.PLAIN_MESSAGE);
				
				return new int[] {0,0};
			}
			
		}
		
		
	}
	
	public  void save()
	{
		String value = GUI.textArea.getText();
		if(GUI.newPath == GUI.changedPath)
			{
				try {
					FileWriter fw = new FileWriter(GUI.newPath);
					//String value = textArea.getText();
					fw.write(value);
					fw.flush();
					fw.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				
			
			JFileChooser chooser = new JFileChooser();
			int option = chooser.showSaveDialog(null);
			
			
			
			if(option == 0)
			{
			try {
											
					File f = chooser.getSelectedFile();
					
					FileWriter fw = new FileWriter(f.getPath());
					GUI.newPath = f.getPath();
					GUI.changedPath = f.getPath();
				//	String value = textArea.getText();
					System.out.println(value);
					fw.write(value);
					fw.flush();
					fw.close();
					System.out.println(chooser.getSelectedFile().getAbsoluteFile());
					GUI.frame.setTitle(GUI.Name+"-"+chooser.getSelectedFile().getName());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}

}//end class
