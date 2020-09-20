import java.awt.event.*;
import java.util.*;

public class GameBoardController{
	
	public GameBoard boardModel;
	public GameBoardView boardView;
	public GameWebale gameWebale;
	
	public int[] moveStored = new int[4];
	public int clickCount = 0;
	public int moveCount = 0;
	
	
	public GameBoardController(GameBoardView boardView, GameBoard boardModel, GameWebale gameWebale) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.gameWebale = gameWebale;
		this.boardView.setPieceRotatedIcon(boardModel.getRedPieceList());
		this.boardView.setPieceIcon(boardModel.getBluePieceList());
		this.boardView.addBoardListener(new BoardListener(boardModel));
		
	}
	
	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getBoardModel() {
		return boardModel;
	}
	
	public class BoardListener implements ActionListener {
		
		GameBoard boardModel;
		public Player currentPlayer;
		public Player[] players = new Player[2];
		
		BoardListener(GameBoard boardModel){
			this.boardModel = boardModel;
			
			try {
				players[0] = new Player(true, "R");
				players[1] = new Player(false, "B");
				currentPlayer = players[0];
				
			} catch (Exception e1) {
				System.out.println("Exception: GameBoardController");
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			if(obj instanceof GameBoardButton){
	
				GameBoardButton clicked = (GameBoardButton)obj;
				int c = clicked.getCol();
				int r = clicked.getRow();
	
				System.out.println("Clicked X:"+ c + " Y:" + r);
				
				try {
					if(clickCount == 0) {
						moveStored[0]=c;
						moveStored[1]=r;
						clickCount++;
					}
					else if(clickCount == 1) {
						moveStored[2]=c;
						moveStored[3]=r;
						clickCount = 0;
						
						System.out.println("Check Point: Board controller: init player move");
						Piece movedPiece = boardModel.getSpot(moveStored[0],moveStored[1]).getPiece();
						boolean isValidPlayerMove = gameWebale.playerMove(currentPlayer, moveStored[0],moveStored[1],moveStored[2],moveStored[3]);
						System.out.println("Check Point: Board controller: finish player move");
						
						//If player move is valid then reset board icon and switch player
						if(isValidPlayerMove) {
							moveCount++;
							System.out.println("Check Point: Board controller change player");
							if (this.currentPlayer == players[0]) { 
								boardView.setButtonIcon(moveStored[0], moveStored[1], movedPiece);
								System.out.println("reset icon and change to player[1]");
								this.currentPlayer = players[1]; 
							} 
							else { 
								boardView.setButtonIcon(moveStored[0], moveStored[1], movedPiece);
								System.out.println("reset icon and change to player[1]");
								this.currentPlayer = players[0]; 
							} 
						}else {
							System.out.println("????? Fail ?????");
						}
						
						//Clear the moveStroed array
						Arrays.fill(moveStored, -1);				
						System.out.println("Click Counter: "+clickCount +"\n\n");
					}
					
					
				} catch (Exception e1) {
					System.out.println("Exception: GameBoardController actionPerformed\n\n");
				}
				
				
			}
		}
	}
	
	

}
