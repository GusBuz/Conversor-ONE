package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboBoxCreator extends JComboBox<String>{

	private static final long serialVersionUID = 2621183758208216190L;

	private static Color COLOR_TITLE = new Color(0x0f314f);
	
	private static Font FONT_COMBO_BUTTON = new Font("Tahoma", Font.PLAIN, 21);
	
	private static int CONTAINER_WIDTH = 150;
	private static int CONTAINER_HEIGHT = 35;

	
	public ComboBoxCreator(String[] array, int x, int y) {
//        this.setFont(FONT_COMBO_BUTTON);
        this.setBounds(x, y, CONTAINER_WIDTH, CONTAINER_HEIGHT);
//        this.setForeground(COLOR_TITLE);
        this.setModel(new DefaultComboBoxModel<>(array));
	}

}
