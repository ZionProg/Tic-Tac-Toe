package assistant;

import java.awt.Point;

import javax.swing.JButton;

import button.Button;
import display.Display;

public class Assistant {
	private Display display;
	private byte ButtonType; // null = 0 : Xbutton = 1 : Obutton = 2
	
	public Assistant(Display disp) {
		display = disp;

	}
	
	public boolean checkForWinner(Point movePosition) {
		 int row,col;
		JButton[][] buttons = display.getButtons();
		 row = movePosition.y;
		 col = movePosition.x;
		 ButtonType = ((Button) buttons[row][col]).getType();
		 
		 //col check
		 for(int j = 0; j < display.getGridDim().getWidth(); ++j){
	            if(((Button) buttons[row][j]).getType() != ButtonType)
	                break;
	            if(j == display.getGridDim().getWidth()-1){
	               return true;
	            }
	        }
		 
		//check row
	        for(int i = 0; i < display.getGridDim().getHeight(); ++i){
	            if(((Button) buttons[i][col]).getType() != ButtonType)
	                break;
	            if(i == display.getGridDim().getHeight()-1){
	                return true;
	            }
	        }
	        
	      //check diag
	        if(row == col){
	            //we're on a diagonal
	            for(int i = 0; i < display.getGridDim().getHeight(); ++i){
	                if(((Button) buttons[i][i]).getType() != ButtonType)
	                    break;
	                if(i == display.getGridDim().getHeight()-1){
	                    return true;
	                }
	            }
	        }
	        
	      //check anti diag
	        if(row + col == display.getGridDim().getHeight() - 1){
	            for(int i = 0; i < display.getGridDim().getHeight(); ++i){
	                if(((Button) buttons[i][(int) ((display.getGridDim().getHeight()-1)-i)]).getType() != ButtonType)
	                    break;
	                if(i == display.getGridDim().getHeight()-1){
	                    return true;
	                }
	            }
	        }	
		return false;
	}
}
