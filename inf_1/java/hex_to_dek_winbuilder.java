import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hex_to_dek_winbuilder {

	private JFrame frame;
	private JTextField input_1;
	private JTextField output_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hex_to_dek_winbuilder window = new hex_to_dek_winbuilder();
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
	public hex_to_dek_winbuilder() {
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
		
		JLabel lblNewLabel = new JLabel("Zadaj hexadecimalné čislo:");
		lblNewLabel.setBounds(53, 35, 160, 23);
		frame.getContentPane().add(lblNewLabel);
		 
		input_1 = new JTextField();
		input_1.setBounds(53, 68, 102, 23);
		frame.getContentPane().add(input_1);
		input_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Premeň");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pouzitie try-catch zapisu 
				//(28.03.2025) Ref.: https://www.w3schools.com/JSREF/jsref_try_catch.asp
				try {
					//na to aby existovala samostatna "metoda v metode" je potrebna trieda (class) ktora ich oddeluje
					//kod vysvetleny v hex_to_dek.java
				class HexDec {
					int hex_dec_partial(int exponent, int multiplier) {
						return multiplier * (int) Math.pow(16, exponent);
					}
					int hex_to_dec_universal(String input) {
						String in = input;
						int result = 0;
						if (input.charAt(input.length() - 1) == 'h') {
							in = input.substring(0, input.length() - 1);
						} else if ((input.charAt(0) == '0' && input.charAt(1) == 'x') || (input.charAt(0) == '0' && input.charAt(1) == 'X')) {
							in = input.substring(2, input.length());
						}	
						for (int k = 0; k < in.length(); k++) {
							if (Character.isDigit(in.charAt(k))) {
								result += hex_dec_partial(k, Integer.parseInt(in.charAt(k) + ""));
							} else {
								switch (in.charAt(k)) {
								case 'A', 'a':
									result += hex_dec_partial(k, 10);
									break;
								case 'B', 'b':
									result += hex_dec_partial(k, 11);
									break;
								case 'C', 'c':
									result += hex_dec_partial(k, 12);
									break;
								case 'D', 'd':
									result += hex_dec_partial(k, 13);
									break;
								case 'E', 'e':
									result += hex_dec_partial(k, 14);
									break;
								case 'F', 'f':
									result += hex_dec_partial(k, 15);
									break;
								default:
									throw new IllegalArgumentException("neplatný vstup pre: " + in.charAt(k));
								}

							}
						}
						return result;
					}
				}
				HexDec hexdec = new HexDec();
				String input = input_1.getText();
				output_1.setText(hexdec.hex_to_dec_universal(input) + "");
				
			}
			 catch (Exception er){
				JOptionPane.showMessageDialog(frame, er + "\nProsím, zadajte platný vstup.", "Chybisko", 2);
			 } 
			}});
		btnNewButton.setBounds(168, 69, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		output_1 = new JTextField();
		output_1.setBounds(53, 130, 102, 23);
		frame.getContentPane().add(output_1);
		output_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Výsledok: ");
		lblNewLabel_1.setBounds(52, 107, 65, 13);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
