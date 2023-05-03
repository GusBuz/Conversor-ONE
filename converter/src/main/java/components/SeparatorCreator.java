package components;

import javax.swing.JSeparator;

public class SeparatorCreator extends JSeparator{

	private static final long serialVersionUID = -664866412150198853L;
	
	private static int SEPARATOR_WIDTH = 510;
	private static int SEPARATOR_HEIGHT = 1;

	
	public SeparatorCreator(int x, int y) {
        this.setLocation(x, y);
        this.setSize(SEPARATOR_WIDTH, SEPARATOR_HEIGHT);
        this.setVisible(true);
	}

}
