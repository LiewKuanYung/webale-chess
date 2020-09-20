import java.awt.event.*;
import java.util.*;

public class GameBoardController{
	
	public GameBoard boardModel;
	public GameBoardView boardView;
	public GameWebale gameWebale;
	
	public int[] moveStored = new int[4];
	public int clickCount = 0;
	
	
	public GameBoardController(GameBoardView boardView, GameBoard boardModel, GameWebale gameWebale) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.gameWebale = gameWebale;
		this.boardView.setPieceRotatedIcon(boardModel.getRedPieceList());
		this.boardView.setPieceIcon(boardModel.getBluePieceList());
		this.boardView.addBoardListener(new BoardListener(boardModel, gameWebale));
		
	}
	
	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getBoardModel() {
		return boardModel;
	}
	
	public class BoardListener implements ActionListener {
		
		GameWebale gameWebale;
		GameBoard boardModel;
		public Player currentPlayer;
		public Player[] players = new Player[2];
		
		BoardListener(GameBoard boardModel, GameWebale gameWebale){
			this.boardModel = boardModel;
			this.gameWebale = gameWebale;
			
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
						System.out.println("Click Counter: "+clickCount);
					}
					else if(clickCount == 1) {
						moveStored[2]=c;
						moveStored[3]=r;
						clickCount = 0;
						
						System.out.println("Check Point: Board controller: init player move");
						Piece endPiece = boardModel.getSpot(moveStored[0],moveStored[1]).getPiece();
						boolean test = gameWebale.playerMove(currentPlayer, moveStored[0],moveStored[1],moveStored[2],moveStored[3]);
						System.out.println("Check Point: Board controller: finish player move");
						
						if(test) {
							System.out.println("Check Point: Board controller change player");
							if (this.currentPlayer == players[0]) { 
								boardView.setButtonIcon(moveStored[0], moveStored[1], endPiece);
								System.out.println("reset icon and change to player[1]");
								this.currentPlayer = players[1]; 
							} 
							else { 
								boardView.setButtonIcon(moveStored[0], moveStored[1], endPiece);
								System.out.println("reset icon and change to player[1]");
								this.currentPlayer = players[0]; 
							} 
						}else {
							System.out.println("??? Not Successful ???");
						}
						
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
