import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cezar_sifra_winbuilder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cezar_sifra_winbuilder window = new cezar_sifra_winbuilder();
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
	public cezar_sifra_winbuilder() {
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

		JTextArea output = new JTextArea();
		output.setBounds(40, 157, 201, 72);
		frame.getContentPane().add(output);

		JTextArea input = new JTextArea();
		input.setBounds(40, 36, 201, 72);
		frame.getContentPane().add(input);

		// desifrovanie
		JButton button_2 = new JButton("Dešifruj");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//na to aby existovala samostatna "metoda v metode" je potrebna trieda (class) ktora ich oddeluje
			//kod je vysvetleny v cezar_sifra.java
				class Cypher {
					String decypher(String input) {
						char whitespace = ' ';
						StringBuilder in = new StringBuilder(input);
						for (int k = 0; k < in.length(); k++) {
							if (in.charAt(k) != whitespace) {
								int original = (int) in.charAt(k);
								char New = (char) (original - 2);
								in.setCharAt(k, New);
							}
						}
						return in.toString();
					}
				}
				String in = input.getText();
				//vytvorenie sifra objektu aby sa volat metoda decypher z triedy
				Cypher sifra = new Cypher();
				output.setText(sifra.decypher(in));

			}
		});
		button_2.setBounds(273, 79, 113, 30);
		frame.getContentPane().add(button_2);

		JLabel lblNewLabel = new JLabel("Vstup :");
		lblNewLabel.setBounds(40, 10, 80, 21);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblVstup = new JLabel("Výstup :");
		lblVstup.setBounds(40, 126, 80, 21);
		frame.getContentPane().add(lblVstup);

		// sifrovanie
		JButton button_1 = new JButton("Šifruj");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//na to aby existovala samostatna "metoda v metode" je potrebna trieda (class) ktora ich oddeluje
				//kod je vysvetleny v cezar_sifra.java
				class Cypher {
					String cypher(String input) {
						char whitespace = ' ';
						StringBuilder in = new StringBuilder(input);
						for (int k = 0; k < in.length(); k++) {
							if (in.charAt(k) != whitespace) {
								int original = (int) in.charAt(k);
								char New = (char) (original + 2);
								in.setCharAt(k, New);
							}
						}
						return in.toString();
					}
				}
				String in = input.getText();
				//vytvorenie sifra objektu aby sa volat metoda cypher z triedy
				Cypher sifra = new Cypher();
				output.setText(sifra.cypher(in));
			}
		});
		button_1.setBounds(273, 39, 113, 30);
		frame.getContentPane().add(button_1);

	}
}
