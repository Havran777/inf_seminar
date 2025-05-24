import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;

public class textovy_editor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textovy_editor window = new textovy_editor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public textovy_editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//textArea
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 32, 332, 203);
		//urcenie fontu
		textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
		frame.getContentPane().add(textArea);
		
		//italic button
		JToggleButton btn_italic = new JToggleButton("italic");
		btn_italic.setBounds(352, 42, 85, 21);
		frame.getContentPane().add(btn_italic);
		
		//bold button
		JToggleButton btn_bold = new JToggleButton("bold");
		btn_bold.setBounds(352, 73, 85, 21);
		frame.getContentPane().add(btn_bold);
		
		//ulozenie textu
		//na principe buffered_writer
		JButton btn_save = new JButton("save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("src/vstup");
					BufferedWriter wr = new BufferedWriter(new FileWriter(file));
					wr.write(textArea.getText());
					wr.close();
				}
				catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		btn_save.setBounds(352, 106, 85, 21);
		frame.getContentPane().add(btn_save);
		
		
		//Action Handlers - definova az ked existuju prislusne elementy (btn_italic a btn_bold) 
		//italic podmienky
		btn_italic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_italic.isSelected() && !btn_bold.isSelected()) {
					textArea.setFont(new Font("Courier New", Font.ITALIC, 20));
				} else if (btn_bold.isSelected() && btn_italic.isSelected()){
					textArea.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
				}
				else if (!btn_italic.isSelected() && btn_bold.isSelected())  {
					textArea.setFont(new Font("Courier New", Font.BOLD, 20));
				} 
				else if (!btn_bold.isSelected() && !btn_italic.isSelected()) {
					textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
				}
			}
		});
		
		//bold podmienky 
		btn_bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(new Font("Courier New", Font.BOLD, 20));
				if (btn_bold.isSelected() && !btn_italic.isSelected()) {
					textArea.setFont(new Font("Courier New", Font.BOLD, 20));
				} else if (btn_italic.isSelected() && btn_bold.isSelected()) {
						textArea.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
				} else if (!btn_bold.isSelected() && btn_italic.isSelected()) {
					textArea.setFont(new Font("Courier New", Font.ITALIC, 20));
				} else if (!btn_bold.isSelected() && !btn_italic.isSelected()) {
					textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
				}
			}
		});
		
		
	}
}
