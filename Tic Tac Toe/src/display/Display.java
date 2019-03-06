package display;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import button.Button;
import main.Game;

public class Display {
	private Game gameReference;
	private final Dimension FRAME_DIM = new Dimension(600, 600);; 
	private final Dimension GRID_DIM = new Dimension(3, 3);
	private JFrame frame;
	private JPanel panel;
	private Button[][] buttons;
	
	public Display(Game ref) {
		gameReference = ref;
		frame = new JFrame("Tic Tac Toe");
		buildFrame();
		panel = new JPanel(new GridLayout(GRID_DIM.width,GRID_DIM.height));
		buttons = new Button[(int) GRID_DIM.getHeight()][(int) GRID_DIM.getWidth()];
		createButtonsOnPanel();
		addToFrame(panel);
	}
	
	private void createButtonsOnPanel() {
		for (int i = 0; i < GRID_DIM.getHeight(); ++i) {
			for (int j = 0; j < GRID_DIM.getWidth(); ++j) {
				buttons[i][j] = new Button(gameReference,i, j);
				buttons[i][j].setDisplayReference(this);
				addToPanel(buttons[i][j]);
			}
		}
	}
	
	private void buildFrame() {
		frame.setMinimumSize(FRAME_DIM);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addToFrame(Component c) {
		frame.add(c);
	}
	
	public void addToPanel(Component c) {
		panel.add(c);
	}
	
	public Button[][] getButtons(){
		return buttons;
	}
	
	public Dimension getGridDim() {
		return GRID_DIM;
	}
	
	public Dimension getFrameDim() {
		return FRAME_DIM;
	}
	
	public Game getGameReference() {
		return gameReference;
	}
	
	public void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
}
