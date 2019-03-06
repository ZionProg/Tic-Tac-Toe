package button;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import display.Display;
import listiner.moveListener;
import utilits.iconLoader;

public class Button extends JButton implements ActionListener {

	public static final byte NO_TYPE = 0;
	public static final byte XBUTTON_TYPE = 1;
	public static final byte YBUTTON_TYPE = 2;
	protected Display disReference;
	protected Point Position;
	protected byte type; // null = 0 : Xbutton = 1 : Obutton = 2
	protected ImageIcon icon;
	protected moveListener listener;

	public Button(moveListener moveListener, int row, int col) {
		addActionListener(this);
		Position = new Point(col, row);
		listener = moveListener;
		icon = null;
		type = 0;
		// addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (icon != null)
			return;

		if (disReference.getGameReference().getPlayerTurn()) {
			icon = iconLoader.loadIcon("/textures/X.png");
			type = XBUTTON_TYPE;
		}

		else {
			icon = iconLoader.loadIcon("/textures/O.png");
			type = YBUTTON_TYPE;
		}
		setIcon(icon);
		notifyMoveMade();
	}

	protected final void notifyMoveMade() {
		listener.moveMade(Position);
	}

	public byte getType() {
		return type;
	}

	public void setType(byte bool) {
		type = bool;
	}

	public final void setDisplayReference(Display display) {
		disReference = display;
	}

	public ImageIcon getButtonIcon() {
		return icon;
	}
}
