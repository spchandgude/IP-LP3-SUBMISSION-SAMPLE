import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Dialog.ModalityType;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import javax.swing.undo.UndoManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class GUI{
//	E://pro//Temp//Untitled.txt
	static JFrame frame = new JFrame();;
	static String Name = "TextEditor";
	static String defaultPath = ".\\Untitled.txt";
	static String newPath = "a";
	static String changedPath = "b";
	static boolean flag =true;
	static boolean SAVEAS = false;
	static boolean EXIT = false;
	
	static String font = "Consolas";
	static int fontStyle = 0 ;
	static int size = 10;
	
	static String fixfont = "Consolas";
	static int fixfontStyle = 0 ;
	static int fixSize = 10;
	
	static int firstIndex = 0;
	static int lastIndex =0; 
	static String FindValue;
	static String context;
	
	static JTextArea textArea;
	private static UndoManager manager = new UndoManager();


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
					//GUI.textArea.setText("");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
			}
			if(x == JOptionPane.NO_OPTION)
			{
				FileWriter fw = new FileWriter(defaultPath);
				frame.dispose();
			}
			
		
	}
	

		GUI(){
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 1220, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newItem = new JMenuItem("New");
		fileMenu.add(newItem);
		
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		
		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		
		JMenuItem saveAsItem = new JMenuItem("Save As");
		fileMenu.add(saveAsItem);
		
		JMenuItem printItem = new JMenuItem("Print");
		fileMenu.add(printItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem undoItem = new JMenuItem("Undo");
		editMenu.add(undoItem);
		
		JMenuItem cutItem = new JMenuItem("Cut");
		editMenu.add(cutItem);
		
		JMenuItem copyItem = new JMenuItem("Copy");
		editMenu.add(copyItem);
		
		JMenuItem pasteItem = new JMenuItem("Paste");
		editMenu.add(pasteItem);
		
		JMenuItem deleteItem = new JMenuItem("Delete");
		editMenu.add(deleteItem);
		
		JMenuItem findItem = new JMenuItem("Find");
		editMenu.add(findItem);
		
		JMenuItem findNextItem = new JMenuItem("Find Next");
		editMenu.add(findNextItem);
		
		JMenuItem replaceItem = new JMenuItem("Replace");
		editMenu.add(replaceItem);
		
		JMenuItem gotoItem = new JMenuItem("Go to");
		editMenu.add(gotoItem);
		
		JMenuItem selectAllItem = new JMenuItem("SelectAll");
		editMenu.add(selectAllItem);
		
		JMenuItem timeDateItem = new JMenuItem("Time/Date");
		editMenu.add(timeDateItem);
		
		JMenu formatMenu = new JMenu("Format");
		menuBar.add(formatMenu);
		
		JCheckBox wordWrapCheckBox = new JCheckBox("Word Wrap");
		wordWrapCheckBox.setHorizontalAlignment(SwingConstants.TRAILING);
		wordWrapCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		formatMenu.add(wordWrapCheckBox);
		
		JMenuItem fontItem = new JMenuItem("Font");
		formatMenu.add(fontItem);
		
		JMenuItem textColorItem = new JMenuItem("Text Color");
		formatMenu.add(textColorItem);
		
		JMenuItem bgColorItem = new JMenuItem("Background Color");
		formatMenu.add(bgColorItem);
		
		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);
		
		JCheckBox statusBarCheckBox = new JCheckBox("Status Bar");
		statusBarCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		viewMenu.add(statusBarCheckBox);
		
		JMenu changeLookMenu = new JMenu("Change Look");
		viewMenu.add(changeLookMenu);
		
		JMenuItem windowsItem = new JMenuItem("Windows");
		changeLookMenu.add(windowsItem);
		
		JMenuItem metalItem = new JMenuItem("Metal");
		changeLookMenu.add(metalItem);
		
		JMenuItem motifItem = new JMenuItem("Motif");
		changeLookMenu.add(motifItem);
		
		textArea = new JTextArea();
	
		
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setFont(new Font("Consolas",Font.PLAIN,10));
	
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						manager.addEdit(e.getEdit());
					}
				});
		
		// ScrollBar
		JScrollPane sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(sp);
		
		//Status Bar
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		frame.getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		JLabel statusLabel = new JLabel("");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		statusPanel.setVisible(false);
		
		
		//default File
		
		try {
			String text = "";
			String path = ".\\Untitled.txt";
			File f =new File(path);
			FileWriter defaultFile = new FileWriter(path);
			frame.setTitle(GUI.Name+"-"+f.getName());
			defaultFile.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
				EXIT = true;
				try {
					ConfirmDialog();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(textArea.getText() == null) 
				{
					undoItem.setEnabled(false);
				}
				else {
					undoItem.setEnabled(true);
				
				}
				
			}
		});
		
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// NEW
				
				NewOperation newOp = new NewOperation();
			}
		});
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//OPEN
				
				JFileChooser FileChooser = new JFileChooser();
				
				  FileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
				  FileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT files", new String[]{"txt"}));
				  FileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Java(.java)", new String[]{"java"}));
				  FileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Python(.py)", new String[]{"py"}));
			       
			 
			        FileChooser.setAcceptAllFileFilterUsed(true);
				
				 int response = FileChooser.showOpenDialog(null);
				 
				 System.out.println(response);
				 if(response == 0) {
					 File f= FileChooser.getSelectedFile();
					 String FilePath = f.getPath();
					 
					 frame.setTitle(Name+"-"+FileChooser.getSelectedFile().getName());
					 try {
						 BufferedReader br = new BufferedReader(new FileReader(FilePath));
						 String s1 = "",temp = "",s2="";
						 while((s1 = br.readLine()) != null) {
							 temp = s1 + "\n";
							 s2 = s2 + temp;
						 }
						 textArea.setText(s2);
						 br.close();
					 }
					 catch(Exception e) {
						 
					 }
					
				 }
			}
		});
		
		
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// SAVE
			
				SaveOperation saveOp = new SaveOperation();
				
			}
		});
		
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//SAVE AS
				SAVEAS = true;
				SaveOperation saveOp = new SaveOperation();
			}
		});
		
		printItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PRINT
				
				try {
					textArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//EXIT
				
				//frame.dispose();
//				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				ReusableFunctions re = new ReusableFunctions();
//				EXIT = true;
//				GUI.ConfirmDialog();
				
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
					frame.dispose();
				}
			}
		});
		
		undoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//UNDO 
				if(textArea.getText() == null) 
				{
					undoItem.setEnabled(false);
				}
				else {
					undoItem.setEnabled(true);
				manager.undo();
				}
			}
		});
		
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// COPY
				if(textArea.getText() == null) 
				{
					copyItem.setEnabled(false);
				}
				else {
					copyItem.setEnabled(true);
					textArea.copy();
				}
			}
		});
		
		pasteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PASTE 
				
				textArea.paste();
				
			}
		});
		
		
		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//DELETE
				
				textArea.replaceSelection("");	
			
			}
		});
		
		cutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CUT
				
				textArea.cut();
			}
		});
		
		findItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FIND
				
				FindDialog f =new FindDialog();

			}
		});
		
		findNextItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FIND NEXT
				
				flag = true;
				String value = GUI.FindValue;
				GUI.context = textArea.getText();
				
				if(value != null)
				{
					int result[] = ReusableFunctions.findOperation(value);
				System.out.println("values are = "+result[0]+"..."+result[1]);
				textArea.select(result[0],result[1]);
				}
				else {
					JOptionPane.showMessageDialog(frame,"please perform Find operation !","Text Editor",JOptionPane.PLAIN_MESSAGE);
					findNextItem.setVisible(false);
				}
				
			}
		});
	 
		selectAllItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//SELECT ALL
				
				textArea.selectAll();
			}
		});
		
		replaceItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//REPLACE
				
				ReplaceFrame Replace = new ReplaceFrame();
				
			}
		});
		
		gotoItem.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent arg0) {
				
				//GO TO
				
				GoToDialog GoTo = new GoToDialog();
				
				}
			});
		
		timeDateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// TIME/DATE
				
				int position = textArea.getCaretPosition();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");  
				LocalDateTime now = LocalDateTime.now();
				textArea.insert(dtf.format(now), position);
				
			}
		});
		
		
		textColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TEXT COLOR
			
				Color color = JColorChooser.showDialog(textArea,"select a Text color", null);
				textArea.setForeground(color);
			}
		});
		
		fontItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FONT
				
				FontFrame fontFrame = new FontFrame(); 
			}
		});
		
		bgColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//BACKGROUND COLOR
				Color color = JColorChooser.showDialog(textArea,"select a Background color", null);
				textArea.setBackground(color);
			}
		});
		
		
		wordWrapCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//WORD WRAP
				if(e.getStateChange() == 1)
				{
					
					textArea.setLineWrap(true);
				}
				if(e.getStateChange() == 2)
				{
					
					textArea.setLineWrap(false);
				}
				
			}
			
		});
		
		statusBarCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//Status Bar
				System.out.println("state = "+e.getStateChange());
				if(e.getStateChange() == 1)
				{
//					textArea.addKeyListener(new KeyAdapter() {
//						@Override
//						public void keyPressed(KeyEvent e) {
//							int length = textArea.getText().length();
//							int lineCount = textArea.getLineCount();
//							String len = String.valueOf(length);
//							sb.setText("Line = "+lineCount+" , Column = "+len);
//							
//						}
//					});
					statusPanel.setVisible(true);	
					textArea.addCaretListener(new CaretListener() {
						public void caretUpdate(CaretEvent arg0) {
				
							int lineCount = textArea.getLineCount();
							int caretPos = textArea.getCaretPosition();
					
							try {
								int offset = Utilities.getRowStart(textArea, caretPos);
								int colNum = caretPos - offset + 1;
								statusLabel.setText("Line = "+lineCount+" , Column = "+colNum);
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
			
						}
					});
				}
					if(e.getStateChange() == 2)
					{
						statusPanel.setVisible(false);
						//sb.setText("");
						
					}
					
					
					
					
				}
		});
		
		windowsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//WINDOWS
				String LAF = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
				try {
					UIManager.setLookAndFeel(LAF);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            //SwingUtilities.updateComponentTreeUI(this);
				new GUI();
			}
		});
		
		metalItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//WINDOWS
				String LAF = "javax.swing.plaf.metal.MetalLookAndFeel";
				try {
					UIManager.setLookAndFeel(LAF);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            //SwingUtilities.updateComponentTreeUI(this);
				new GUI();
			}
		});
		
		motifItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//WINDOWS
				String LAF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
				try {
					UIManager.setLookAndFeel(LAF);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            //SwingUtilities.updateComponentTreeUI(this);
				new GUI();
			}
		});
		
	}// end of constructor	

}// end of class
