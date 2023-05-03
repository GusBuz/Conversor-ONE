package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class TextFieldCreator extends JTextField{
	
	private static final long serialVersionUID = 1605442926337440372L;

	private static Color COLOR_TEXT = new Color(0x1c5487);

	private static Font FONT_TEXTFIELD = new Font("Tahoma", Font.PLAIN, 25);
	
	private static int CONTAINER_WIDTH = 150;
	private static int CONTAINER_HEIGHT = 35;
	
	public TextFieldCreator(int x, int y) {
        this.setHorizontalAlignment(JTextField.CENTER);
//        this.setForeground(COLOR_TEXT);
//        this.setFont(FONT_TEXTFIELD);
        this.setBounds(x, y, CONTAINER_WIDTH, CONTAINER_HEIGHT);
}}
