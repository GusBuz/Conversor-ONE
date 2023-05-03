package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class LabelCreator extends JLabel{

	private static final long serialVersionUID = -5721810188020602901L;

	private static Color COLOR_TEXT = new Color(0x1c5487);
	private static Color COLOR_ERROR = new Color(0xd7373d);	
	private static Font FONT_LABEL = new Font("Tahoma", Font.PLAIN, 15);
	private static Font FONT_TITLE_EXCEPTION = new Font("Tahoma", Font.PLAIN, 17);
	private static int LABEL_WIDTH = 135;
	private static int LABEL_HEIGHT = 20;
	
	public LabelCreator(String text, int x, int y) {
		this.setText(text);
		this.setHorizontalAlignment(SwingConstants.CENTER);
//		this.setForeground(COLOR_TEXT);
//		this.setFont(FONT_LABEL);
		this.setBounds(x, y, LABEL_WIDTH, LABEL_HEIGHT);
	}
	
	public void setExceptionLabel(int width, int height) {
        this.setBounds(this.getX(), this.getY(), width, height);
        this.setForeground(COLOR_ERROR);
        this.setVisible(false);
	}
}
