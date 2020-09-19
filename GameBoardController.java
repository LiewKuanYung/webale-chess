import java.awt.event.*;

public class GameBoardController{
	
	private GameBoard boardModel;
	private GameBoardView boardView;
	
	
	public GameBoardController(GameBoard boardModel, GameBoardView boardView) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.boardView.addBoardListener(new BoardListener());
	}
	
	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getGameBoardModel() {
		return boardModel;
	}
	
	class BoardListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object obj = e.getSource();
			if(obj instanceof GameBoardButton){
	
				GameBoardButton clicked = (GameBoardButton)obj;
				int r = clicked.getCol();
				int c = clicked.getRow();
	
				System.out.println("Clicked X:"+r+" Y:"+c);
			}
		}
	}
	
	

}
