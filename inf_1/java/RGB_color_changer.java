/*import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class RGB_color_changer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RGB_color_changer window = new RGB_color_changer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RGB_color_changer() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setBounds(59, 33, 219, 26);
		frame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBounds(59, 69, 219, 26);
		frame.getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setBounds(59, 105, 219, 26);
		frame.getContentPane().add(slider_2);
		
		textField = new JTextField();
		textField.setBounds(288, 33, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(288, 69, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(288, 105, 96, 19);
		frame.getContentPane().add(textField_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 141, 268, 94);
		frame.getContentPane().add(editorPane);
		
		JLabel lblNewLabel = new JLabel("RED:");
		lblNewLabel.setBounds(10, 33, 45, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GREEN:");
		lblNewLabel_1.setBounds(10, 69, 45, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("BLUE:");
		lblNewLabel_1_1.setBounds(10, 105, 45, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
	}
}
*/

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RGB_color_changer {

    private JFrame frame;
    private JTextField textfield_red;    
    private JTextField textfield_green; 
    private JTextField textfield_blue; 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RGB_color_changer window = new RGB_color_changer();
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
    public RGB_color_changer() {
        initialize();
    }
    //premenne na ukladanie stavov farieb - hodnoty zo scrollbarov alebo vstupov (textfieldov)
    int red = 0;
    int blue = 0;
    int green = 0;
    //urcenie prvotnej farby - cierna
    Color color = new Color(0, 0, 0);
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        //ELEMENT MENIACI FARBU - vydiet zmeny ked 
        JPanel elementPane = new JPanel();
        elementPane.setBounds(10, 141, 414, 109);
        //asi na aktivne zachytavanie zmien ale neovplynuje to funkciu
        elementPane.setBackground(SystemColor.activeCaption);
        elementPane.setBackground(color);
        frame.getContentPane().add(elementPane);
        
        //SCROLLBAR RED
        JScrollBar scrollbar_red = new JScrollBar();
        //.setBlockIncrement() ; .setMaximum() - vacsie o 10 asi kvoli dlzke elementu, .setOrientation(JScrollBar.HORIZONTAL)
        //vsetky tri su podstatne aby scrollbar fungoval ako ma
        scrollbar_red.setBlockIncrement(0);
        scrollbar_red.setMaximum(265);
        scrollbar_red.setOrientation(JScrollBar.HORIZONTAL);
        //zachytavanie hodnoty scrollbaru ked sa s nim hybe 
        scrollbar_red.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		red = scrollbar_red.getValue();
        		//meni sa aj hodnota v textfield dynamicky podla hybania
        		textfield_red.setText(red + "");
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        scrollbar_red.setBounds(76, 33, 224, 26);
        frame.getContentPane().add(scrollbar_red);
        
        
        //SCROLLBAR GREEN
        //rovnako funguje ako SCROLLBAR RED 
        JScrollBar scrollbar_green = new JScrollBar();
        scrollbar_green.setBounds(76, 69, 224, 26);
        scrollbar_green.setBlockIncrement(0);
        scrollbar_green.setMaximum(265);
        scrollbar_green.setOrientation(JScrollBar.HORIZONTAL);
        scrollbar_green.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		green = scrollbar_green.getValue();
        		textfield_green.setText(green + "");
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        frame.getContentPane().add(scrollbar_green);
        
        //SCROLLBAR BLUE
        //rovnako funguje ako SCROLLBAR RED 
        JScrollBar scrollbar_blue = new JScrollBar();
        scrollbar_blue.setBounds(76, 105, 224, 26);
        scrollbar_blue.setBlockIncrement(0);
        scrollbar_blue.setMaximum(265);
        scrollbar_blue.setOrientation(JScrollBar.HORIZONTAL);
        scrollbar_blue.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		blue = scrollbar_blue.getValue();
        		textfield_blue.setText(blue + "");
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        frame.getContentPane().add(scrollbar_blue);
        
      
        
        //RED FIELD
        textfield_red = new JTextField();
        //zachytavanie zmien ked v inpute z textfieldu
        textfield_red.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		//podmienka na ci je string v textfield cislo - ak nie tak sa automaticky vymaze, hodnota sa nezada
        		String red_text = textfield_red.getText();
        		if (red_text != null && !red_text.isEmpty() && red_text.chars().allMatch(Character::isDigit)) {
        			//cislo od 0 po 255
        			if (Integer.parseInt(red_text) >= 0 && Integer.parseInt(red_text) <= 255) {
        				red = Integer.parseInt(red_text);
        				textfield_red.setText(red_text);
        			//cisla vacsie od 255
        				} else if (Integer.parseInt(red_text) > 255) {
        				red = 255;
        				textfield_red.setText("255");
        				}
        			} else {
        				red = 0;
        				textfield_red.setText("");
        			}
        		scrollbar_red.setValue(red);
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        textfield_red.setBounds(328, 38, 96, 19);
        frame.getContentPane().add(textfield_red);
        textfield_red.setColumns(10);
        
        //GREEN FIELD
        textfield_green = new JTextField();
        textfield_green.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		String green_text = textfield_green.getText();
        		if (green_text != null && !green_text.isEmpty() && green_text.chars().allMatch(Character::isDigit)) {
        			if (Integer.parseInt(green_text) >= 0 && Integer.parseInt(green_text) <= 255) {
        				green = Integer.parseInt(green_text);
        				textfield_green.setText(green_text);
        				} else if (Integer.parseInt(green_text) > 255) {
        				green = 255;
        				textfield_green.setText("255");
        				}
        			} else {
        				green = 0;
        				textfield_green.setText("");
        			}
        		scrollbar_green.setValue(green);
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        textfield_green.setColumns(10);
        textfield_green.setBounds(328, 69, 96, 19);
        frame.getContentPane().add(textfield_green);
        
        //BLUE FIELD
        textfield_blue = new JTextField();
        textfield_blue.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		String blue_text = textfield_blue.getText();
        		if (blue_text != null && !blue_text.isEmpty() && blue_text.chars().allMatch(Character::isDigit)) {
        			if (Integer.parseInt(blue_text) >= 0 && Integer.parseInt(blue_text) <= 255) {
        				blue = Integer.parseInt(blue_text);
        				textfield_blue.setText(blue_text);
        				} else if (Integer.parseInt(blue_text) > 255) {
        				blue = 255;
        				textfield_blue.setText("255");
        				}
        			} else {
        				blue = 0;
        				textfield_blue.setText("");
        			}
        		scrollbar_blue.setValue(blue);
        		color = new Color (red, green, blue);
        		elementPane.setBackground(color);
        	}
        });
        textfield_blue.setColumns(10);
        textfield_blue.setBounds(328, 105, 96, 19);
        frame.getContentPane().add(textfield_blue);
    
        
        //--- LABELS ---
        JLabel lblNewLabel = new JLabel("RED:");
        lblNewLabel.setBounds(10, 33, 56, 26);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("GREEN:");
        lblNewLabel_1.setBounds(10, 69, 56, 26);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("BLUE:");
        lblNewLabel_1_1.setBounds(10, 105, 56, 26);
        frame.getContentPane().add(lblNewLabel_1_1);
      
    }
}