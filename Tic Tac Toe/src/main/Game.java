package main;

import java.awt.Point;

import javax.swing.JOptionPane;

import assistant.Assistant;
import button.Button;
import display.Display;
import listiner.moveListener;

public class Game implements moveListener {
		
	private Display display;
	private Assistant assistant;
	private String theWinnerIs;
	private boolean playerTurn;
	private boolean winner;
	private boolean madeMove;
	private byte movesMade;
	private Point movePosition;
	private final  Byte DRAWGAME = 9;
		
		public Game() {
			display = new Display(this);
			assistant = new Assistant(display);
			movePosition = new Point(0, 0);
			playerTurn = true;
			winner = false;
			madeMove = false;
			movesMade = 0;
			theWinnerIs = null;
		}
	
	public void start() {
		
		while(!winner && movesMade != DRAWGAME) {
			Thread.yield(); // without this the program will get stuck because of the multy threading, need to slow a bit 
			if(madeMove) {
				++movesMade;
				winner = assistant.checkForWinner(movePosition);
				madeMove = false;
			}
		}
		
		if(winner) {
			if(display.getButtons()[movePosition.y][movePosition.x].getType() == Button.XBUTTON_TYPE)
				theWinnerIs = "XPlayer!";
			else
				theWinnerIs = "OPlayer!";
			
			JOptionPane.showMessageDialog(null, "The winner is: " + theWinnerIs);
		}
		
		else if(movesMade == DRAWGAME) {
			JOptionPane.showMessageDialog(null, "Draw Game!");
		}
		display.closeFrame();
	}

	@Override
	public void moveMade(Point movePos) {
		madeMove = true;
		playerTurn = !playerTurn;
		movePosition.setLocation(movePos);
	}
	
	public boolean getPlayerTurn() {
		return playerTurn;
	}
	
	
}
