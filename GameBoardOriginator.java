/**
 * @author Liew Kuan Yung
 */

// Memento Design Pattern
public class GameBoardOriginator {

	private GameBoardSpot[][] board = new GameBoardSpot[8][7];
	private int totalMoveCount;

	// Sets the value for the board
	public void set(GameBoardSpot[][] boardSave, int totalMoveCountSave) { 
		for(int i = 0; i < 8; i++) { //Y axis
	        for(int j = 0; j < 7; j++) { //X axis
	        	if (boardSave[i][j].getPiece() == null) {
	        		board[i][j] = new GameBoardSpot (j , i ,null);
	        	} else {
	        		board[i][j] = boardSave[i][j];
	        	}
	        } 
		}   
		totalMoveCount = totalMoveCountSave;
		System.out.println("\n\nOriginator current total move count: "+totalMoveCount);
	}

	// Creates a new GameBoardMemento with board and move
	public GameBoardMemento storeInGameBoardMemento() { 
		System.out.println("Originator: Saving to Memento");
		return new GameBoardMemento(board, totalMoveCount); 
	}
	

	// Gets the board that currently stored in GameBoardMemento
	public GameBoardSpot[][] restoreBoard(GameBoardMemento memento) {

		board = memento.getSavedBoard(); 
		System.out.println("Originator: Restore Previous Board Saved in Memento");
		return board;
	}
	
	// Gets the total move that currently stored in GameBoardMemento
	public int restoreTotalMoveCount(GameBoardMemento memento) {
		
		totalMoveCount = memento.getSavedTotalMoveCount();
		System.out.println("Originator: Restore Previous totalMoveCount Saved in Memento");
		return totalMoveCount;
	}


}
