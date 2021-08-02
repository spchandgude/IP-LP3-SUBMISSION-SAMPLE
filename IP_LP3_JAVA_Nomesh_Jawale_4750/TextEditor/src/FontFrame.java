import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FontFrame {

	private JFrame frame;


	public FontFrame() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 14));
		frame.setVisible(true);
		frame.setBounds(100, 100, 842, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel sampleLabel = new JLabel("aAbBcCdD");
		sampleLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		sampleLabel.setBounds(216, 28, 245, 69);
		 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		 sampleLabel.setBorder(border);
		frame.getContentPane().add(sampleLabel);
		
		JList fontList = new JList();
		fontList.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fontList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Arial", "Consolas", "Serif", "Monospaced", "Times New Roman"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontList.setBounds(39, 179, 141, 204);
		frame.getContentPane().add(fontList);
		
		JList fontStyleList = new JList();
		fontStyleList.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fontStyleList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Regular", "Bold", "Italic", "bold Itlaic"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		fontStyleList.setBounds(274, 179, 141, 204);
		frame.getContentPane().add(fontStyleList);
		
		JList sizeList = new JList();
		sizeList.setFont(new Font("SansSerif", Font.PLAIN, 14));
		sizeList.setModel(new AbstractListModel() {
			int[] values = new int[] {10, 12, 14, 16, 18};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sizeList.setBounds(523, 179, 141, 204);
		frame.getContentPane().add(sizeList);
		
		JLabel fontLabel = new JLabel("");
		fontLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fontLabel.setBounds(39, 142, 141, 13);
		frame.getContentPane().add(fontLabel);
		
		JLabel fontStyleLabel = new JLabel("");
		fontStyleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fontStyleLabel.setBounds(274, 142, 141, 13);
		frame.getContentPane().add(fontStyleLabel);
		
		JLabel sizeLabel = new JLabel("");
		sizeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		sizeLabel.setBounds(523, 142, 141, 13);
		frame.getContentPane().add(sizeLabel);
		
		JButton okButton = new JButton("Ok");
		okButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		okButton.setBounds(443, 417, 102, 33);
		frame.getContentPane().add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		cancelButton.setBounds(588, 417, 102, 33);
		frame.getContentPane().add(cancelButton);
		
		JLabel lblNewLabel = new JLabel("Sample : ");
		lblNewLabel.setBounds(161, 44, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		
		fontList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				GUI.fixfont = fontList.getSelectedValue().toString();
				//lblNewLabel.setFont(Font,fontStyle,size);
				sampleLabel.setFont(new Font(GUI.fixfont,GUI.fontStyle,GUI.fixSize));
				fontLabel.setText(GUI.fixfont);
			}
		});
		
		fontStyleList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				 String style = fontStyleList.getSelectedValue().toString();
					if(style == "Italic")
						GUI.fixfontStyle = 2;
					if(style == "Bold")
						GUI.fixfontStyle = 1;
					if(style == "Regular")
						GUI.fixfontStyle = 0;
				
				sampleLabel.setFont(new Font(GUI.fixfont,GUI.fixfontStyle,GUI.fixSize));
				fontStyleLabel.setText(style);
				
			}
		});
		
		sizeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				GUI.fixSize = (int)sizeList.getSelectedValue();
				String size = sizeList.getSelectedValue().toString();
				sampleLabel.setFont(new Font(GUI.fixfont,GUI.fixfontStyle,GUI.fixSize));
				
				System.out.println(Font.BOLD+"   "+Font.ITALIC+"  "+Font.PLAIN+"  ");
				sizeLabel.setText(size);
				
			}
		});
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.textArea.setFont(new Font(GUI.fixfont,GUI.fixfontStyle,GUI.fixSize));
				frame.dispose();
				GUI.font = GUI.fixfont;
				GUI.fontStyle = GUI.fixfontStyle;
				GUI.size = GUI.fixSize; 
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GUI.textArea.setFont(new Font(GUI.font,GUI.fontStyle,GUI.size));
				frame.dispose();
			}
		});
		
	}// end of constructor
}// end of class
