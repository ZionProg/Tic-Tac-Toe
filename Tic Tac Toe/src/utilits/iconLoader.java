package utilits;

import javax.swing.ImageIcon;

public class iconLoader {
	public static ImageIcon loadIcon(String path) {
		return new ImageIcon(iconLoader.class.getResource(path));
	}
}
