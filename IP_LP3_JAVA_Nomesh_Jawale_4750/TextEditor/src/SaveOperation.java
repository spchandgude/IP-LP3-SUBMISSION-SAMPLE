import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveOperation{
	
	public static File getSelectedFileWithExtension(JFileChooser c) {
		
	    File file = c.getSelectedFile();
	    if (c.getFileFilter() instanceof FileNameExtensionFilter) {
	        String[] exts = ((FileNameExtensionFilter)c.getFileFilter()).getExtensions();
	        String nameLower = file.getName().toLowerCase();
	        for (String ext : exts) { // check if it already has a valid extension
	            if (nameLower.endsWith('.' + ext.toLowerCase())) {
	                return file; // if yes, return as-is
	            }
	        }
	        // if not, append the first extension from the selected filter
	        file = new File(file.toString() + '.' + exts[0]);
	    }
	    return file;
	}
	
	
	SaveOperation(){
	String value = GUI.textArea.getText();
	if(GUI.newPath == GUI.changedPath && GUI.SAVEAS == false)
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
			if(GUI.SAVEAS == true)
			{
				GUI.SAVEAS = false;
			}
		
		JFileChooser chooser = new JFileChooser();
		  chooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (.txt))", new String[]{"txt"}));
		  chooser.addChoosableFileFilter(new FileNameExtensionFilter("Java(.java)", new String[]{"java"}));
		  chooser.addChoosableFileFilter(new FileNameExtensionFilter("Python(.py)", new String[]{"py"}));
		  chooser.setFileFilter(new FileNameExtensionFilter("XML(.xml)", "xml"));
		  
		int option = chooser.showSaveDialog(null);
		
		String str = chooser.getFileFilter().toString();
		str.indexOf("extensions =");
		System.out.println(str);
		System.out.println("fiele FIlter"+chooser.getFileFilter());
		
		//Pattern p = Pattern.compile("extensions=[");
		//Matcher m = p.matcher(str);
		
		
		
//		chooser.choos
//		String typeF[] = chooser.getFileFilter();
//		System.out.println();
	

		if(option == 0)
		{
		try {
										
				File f = chooser.getSelectedFile();
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("txt file", "txt"));
				String path = null;
				if(str.matches(".*?\\bjava\\b.*?"))
				{
					String ext = ".java";
					path = f.getPath()+""+ext;
					FileWriter fw = new FileWriter(path);
					fw.write(value);
					fw.flush();
					fw.close();
				}
				
				if(str.matches(".*?\\bPython\\b.*?"))
				{
					String ext = ".py";
					path = f.getPath()+""+ext;
					FileWriter fw = new FileWriter(path);
					fw.write(value);
					fw.flush();
					fw.close();
				}
				if(str.matches(".*?\\btxt\\b.*?"))
				{
					String ext = ".txt";
					path = f.getPath()+""+ext;
					FileWriter fw = new FileWriter(path);
					fw.write(value);
					fw.flush();
					fw.close();
				}
				if(str.matches(".*?\\bxml\\b.*?"))
				{
					String ext = ".xml";
					path = f.getPath()+""+ext;
					FileWriter fw = new FileWriter(path);
					fw.write(value);
					fw.flush();
					fw.close();
				}

				GUI.newPath = path;
				GUI.changedPath = path;
	
				
				System.out.println(chooser.getSelectedFile().getAbsoluteFile());
				GUI.frame.setTitle(GUI.Name+"-"+chooser.getSelectedFile().getName());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}


	
}// end of constructor
	
}// end of class
