import java.awt.event.*;

public class GameBoardController{
	
	private GameBoard boardModel;
	private GameBoardView boardView;
	
	
	public GameBoardController(GameBoard boardModel, GameBoardView boardView) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.boardView.addBoardListener(new BoardListener(boardModel));
	}
	
	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getGameBoardModel() {
		return boardModel;
	}
	
	class BoardListener implements ActionListener {
		
		GameBoard boardModel;
		BoardListener(GameBoard boardModel){
			this.boardModel = boardModel;
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
					
					boardModel.getSpot(c, r);
					/*
					if(boardModel.getSpot(r, c).isEmpty()) {
						System.out.print("Nothing here");
					} else {
						System.out.print(boardModel.getSpot(r, c).getPiece().getPieceName());
					}/**/
				} catch (Exception e1) {
					System.out.println("GameBoardController: actionPerformed exception");
					//e1.printStackTrace();
				}
				
				
			}
		}
	}
	
	

}
