
public class GameBoardMemento {
	
	// The board array stored in GameBoardMemento Object
	private GameBoardSpot[][] board = new GameBoardSpot[8][7];;
	private int totalMoveCount;

	
	// Save a new board array and totalMoveCount to the GameBoardMemento Object
	public GameBoardMemento(GameBoardSpot[][] boardSave, int totalMoveCountSave) { 
		System.out.print("\n********** ********** **********\n"
						 + "  GameBoardMemento Saved"
						 + "\n********** ********** **********\n");
		for(int i = 0; i < 8; i++) { //Y axis
	        for(int j = 0; j < 7; j++) { //X axis
	        	if (boardSave[i][j].getPiece() == null) {
	        		System.out.print("null   ");
	        		board[i][j] = new GameBoardSpot (j , i ,null);
	        	} else {
	        		board[i][j] = new GameBoardSpot (j , i , setNewPiece(boardSave[i][j].getPiece()));
	        		System.out.print(board[i][j].getPiece().getPieceInfo()+ " ");
	        	}
	        } System.out.print("\n");
		}   
		totalMoveCount = totalMoveCountSave;
		System.out.println("********** ********** **********\n"
						 + "  TotalMove Saved: " + totalMoveCount
						 + "\n********** ********** **********\n");
	}
	
	public Piece setNewPiece(Piece p) {

		char info[] = new char[3];
		if(p != null) {
			String pieceInfo = p.getPieceInfo();	
			info[0] = pieceInfo.charAt(0);
			info[1] = pieceInfo.charAt(1);
			info[2] = pieceInfo.charAt(2);
			String pieceName = String.valueOf(info);
			String color;
			if('R' == pieceInfo.charAt(3)) {
				color = "R";
			} else {
				color = "B";
			}
			int x = Character.getNumericValue(pieceInfo.charAt(4));
			int y = Character.getNumericValue(pieceInfo.charAt(5));
			
			p = null; //Delete the piece first
			switch(pieceName) 
			{
			case "SUN" :
				p = new Sun(x, y, color);
				break;
			case "PLS" :
				p = new Plus(x, y, color);
				break;
			case "TRI" :
				p = new Triangle(x, y, color);
				break;
			case "CHV" :
				p = new Chevron(x, y, color);
				break;
			case "ARR" :
				p = new Arrow(x, y, color);
				break;
			default :
				System.out.print("\n\n\n\n ***************\n" 
							   + "ERROR INVALID PIECES"
							   + "PLEASE CHECK GameBoardMemento"
						       + "\n ***************\n\n\n");
			}
		}	
		return p;
	}
	

	// Return the value stored in GameBoardMemento
	public GameBoardSpot[][] getSavedBoard() { return board; }
	public int getSavedTotalMoveCount() {return totalMoveCount; }

}
