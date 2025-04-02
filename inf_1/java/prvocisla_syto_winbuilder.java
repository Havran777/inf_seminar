import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class prvocisla_syto_winbuilder {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prvocisla_syto_winbuilder window = new prvocisla_syto_winbuilder();
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
	public prvocisla_syto_winbuilder() {
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
		
		JLabel lblNewLabel = new JLabel("Horná hranica intervalu:\r\n");
		lblNewLabel.setBounds(10, 33, 166, 32);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(186, 40, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prvočisla (od 2 po n):");
		lblNewLabel_1.setBounds(10, 63, 166, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		//scrollpane - skrolovanie
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 97, 387, 145);
		frame.getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("Výsledok");
		btnNewButton.addActionListener(new ActionListener() {
			//prvocisla - vlastny algoritmus na pocitanie prvocisel 
			public void actionPerformed(ActionEvent e) {
				int input = Integer.parseInt(textField.getText());
				//pomocna premenna na vysledok
				String output = "";

				//loop na prechadzanie prirodzenych cisel od 2 po n - ide reverzom takze od n, n - 1, n - 2, ... 2  
				for (int k = input; k >= 2; k--) {   
					boolean res = true;
					
					//iteracia cez cisla az po n - 1 (lebo n / n je vzdy jedna 1) 
					for (int i = 2; i <= k - 1; i++) {
						//ak sa najde co len jeden delitel - res bude false a stopne sa cyklus
						if (k % i == 0) {
							res = false;
							break;
						}
					}
					//ak sa nenasiel delitel -> ak sa res nezmenil na false, tak je cislo zahrnute vo vyslednej premennej
					if (res == true) {
						// \n - charakter na vytvorenie novej linie
						output = output + k + "\n";
					}
				}

				textArea.setText(output);
			}
		});
		btnNewButton.setBounds(291, 38, 106, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
