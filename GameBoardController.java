import java.awt.event.*;
import java.util.*;

public class GameBoardController{
	
	public GameBoard boardModel;
	public GameBoardView boardView;
	public GameWebale gameWebale;
	
	public Player[] players = new Player[2];
	public int[] moveStored = new int[4];
	public int clickCount = 0;
	public int totalMoveCount = 0;
	
	
	public GameBoardController(GameBoardView boardView, GameBoard boardModel, GameWebale gameWebale) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.gameWebale = gameWebale;
		this.boardView.setAllPiecesRotatedIcon(boardModel.getRedPieceList());
		this.boardView.setAllPiecesIcon(boardModel.getBluePieceList());
		this.boardView.addBoardListener(new BoardListener());
	}
	
	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getBoardModel() {
		return boardModel;
	}
	
	public class BoardListener implements ActionListener {
		
		public Player currentPlayer;
		BoardListener(){

			try {
				players[0] = new Player(true, "R");
				players[1] = new Player(false, "B");
				currentPlayer = players[0];
				
			} catch (Exception ex) {
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
						boardView.showButtonColor(moveStored[0],moveStored[1]);
						if(!boardModel.getSpot(c, r).isEmpty()) {
							showAllValidMove(c, r, true);
						}
					}
					else if(clickCount == 1) {
						moveStored[2]=c;
						moveStored[3]=r;
						clickCount = 0;
						boardView.doNotShowButtonColor(moveStored[0],moveStored[1]);	
						if(!boardModel.getSpot(moveStored[0],moveStored[1]).isEmpty()) {
							showAllValidMove(moveStored[0],moveStored[1], false);
						}
						
						Piece movedPiece = boardModel.getSpot(moveStored[0],moveStored[1]).getPiece();
						boolean isValidPlayerMove = gameWebale.playerMove(currentPlayer, moveStored[0],moveStored[1],moveStored[2],moveStored[3]);
						
						//If player move is valid then 
						// Move Piece, reset icon and switch player
						if(isValidPlayerMove) {
							totalMoveCount++;
							movedPiece.move(moveStored[0],moveStored[1],moveStored[2],moveStored[3]);
							if (this.currentPlayer == players[0]) { 
								boardView.setValidMoveIcon(moveStored[0], moveStored[1], movedPiece);
								this.currentPlayer = players[1];
								System.out.println("reset icon, current player change to player[1]");
							} 
							else { 
								boardView.setValidMoveIcon(moveStored[0], moveStored[1], movedPiece);
								this.currentPlayer = players[0]; 
								System.out.println("reset icon, current player change to player[0]");
							} 
							
							//Change Plus to Triangle, vice versa
							changePlusToTriangle();
							
						}else {
							System.out.println("????? Fail ?????");
						}
						
						//Clear and reset the moveStored array
						Arrays.fill(moveStored, -1);				
						System.out.println("Click Counter: "+clickCount +"\n\n");
					}
				} catch (Exception e1) {
					System.out.println("Exception: GameBoardController fail actionPerformed\n\n");
				}
			}
		}
		
		public void showAllValidMove(int startX, int startY, boolean show) throws Exception {
			for(int y = 0; y < 8; y++){
				for(int x = 0; x < 7; x++){
					if(boardModel.getSpot(startX,startY).getPiece().isValidMove(boardModel, boardModel.getSpot(startX,startY), boardModel.getSpot(x,y))) {
						if(show == true) {
							boardView.showButtonColor(x,y);
						}else if (show == false){
							boardView.doNotShowButtonColor(x, y);
						}
					}
				}
			}
		}
		
		public void changePlusToTriangle() throws Exception {
			if(totalMoveCount % 4 == 0) {
				for(int y = 0; y < 8; y++){
					for(int x = 0; x < 7; x++){
						if(!boardModel.getSpot(x,y).isEmpty()){
							if(boardModel.getSpot(x,y).getPiece() instanceof Plus 
									|| boardModel.getSpot(x,y).getPiece() instanceof Triangle) {
								boardModel.changePlusAndTriangle(x, y);
								boardView.setOneIcon(boardModel.getSpot(x, y).getPiece());
							} 
						}
					}
				}
			}
		}
	}
	
	

}
