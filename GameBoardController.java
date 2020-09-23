/**
 * @author Liew Kuan Yung
 * @ID 1191301064
 */

import java.awt.event.*;
import javax.swing.JButton;
import java.util.*;
public class GameBoardController{
	
	// ---------------------------------------------
	
	// MVC Design
	// View : Controller(this) : Model
	// GameWebale contains the flow of game
	
	public GameBoard boardModel;
	public GameBoardView boardView;
	public GameWebale gameWebale;
	public Player[] players = new Player[2];
	
	// ---------------------------------------------
	
	//Mouse click counter
	public int clickCount = 0;
	public int[] clickStored = new int[4];
	
	// ---------------------------------------------
	
	//Total moves counter
	//odd number = player 1
	//even number = player 2
	public int totalMoveCount = 1; 
	
	// ---------------------------------------------
	
	// Create a caretaker that contains the ArrayList 
	// with all the articles in it. It can add and
	// retrieve articles from the ArrayList

	GameBoardCaretaker caretaker = new GameBoardCaretaker();

	// The originator sets the value for the article,
	// creates a new memento with a new article, and 
	// gets the article stored in the current memento

	GameBoardOriginator originator = new GameBoardOriginator();

	int savedMemento = 0;
	
	// ---------------------------------------------
	
	
	public GameBoardController(GameBoardView boardView, GameBoard boardModel, GameWebale gameWebale) {
		this.boardModel = boardModel;
		this.boardView = boardView;
		this.gameWebale = gameWebale;
		boardView.displayBoard(boardModel.getEntireGameBoardSpot(), false); //false because no flip
		this.boardView.addBoardListener(new BoardListener());
		// Set the value for the current memento				
		originator.set(boardModel.getEntireGameBoardSpot(), totalMoveCount);
		// Add new article to the ArrayList	
		caretaker.addGameBoardMemento( originator.storeInGameBoardMemento());
	}

	public GameBoardView getBoardView() {
		return boardView;
	}
	
	public GameBoard getBoardModel() {
		return boardModel;
	}
	
	public int getTotalMoveCount() {
		return totalMoveCount;
	}
	
	public void setTotalMoveCount(int totalMovePlayed) {
		this.totalMoveCount = totalMovePlayed;
	}
	
	public void resetBoard() {
		
		//Game Webale reset
		boardModel.resetBoard();
		boardView.clearBoardView();
		boardView.displayBoard(boardModel.getEntireGameBoardSpot(), false); //false because no flip
		gameWebale.setStatus(GameStatus.ACTIVE);
		totalMoveCount = 1;
		
		// Reset the value for the current memento	
		savedMemento = 0;
		originator.set(boardModel.getEntireGameBoardSpot(), totalMoveCount);
		// Clear ArrayList
		caretaker.clearGameBoardMemento();
		// Add new article to the ArrayList
		caretaker.addGameBoardMemento( originator.storeInGameBoardMemento());
	}
	
	public void loadBoard(ArrayList<String> loadPiecesList, int totalMovePlayed) {
		boardModel.loadBoard(loadPiecesList);
		setTotalMoveCount(totalMovePlayed);
		boardView.clearBoardView();
		
		boolean flip = false;
		if(totalMovePlayed % 2 == 0) { //Blue player's turn, need to flip board 
			flip = true;
		}
		
		boardView.displayBoard(boardModel.getEntireGameBoardSpot(), flip);
		
		// Set the value for the current memento				
		originator.set(boardModel.getEntireGameBoardSpot(), totalMoveCount);
		// Add new article to the ArrayList	
		caretaker.addGameBoardMemento( originator.storeInGameBoardMemento());
	}
	
	public class BoardListener implements ActionListener {
		
		public Player currentPlayer;
		BoardListener(){

			try {
				boolean isPlayer1 = true;
				players[0] = new Player(isPlayer1, "R");
				players[1] = new Player(!isPlayer1, "B");
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
				int r_Flip = r; // for flip board
				int c_Flip = c;
	
				System.out.println("Clicked X:"+ c + " Y:" + r);
				
				boolean flip = false;
				if (totalMoveCount % 2 == 0) { 
					// 2nd Player's turn: Red Player
					this.currentPlayer = players[1];
					flip = true; //flip the board upside down
					r_Flip = 7 - r_Flip;
					c_Flip = 6 - c_Flip;
					System.out.println("Current player is player[1] blue");
				} 
				else { 
					// 1st Player's turn: Blue Player
					this.currentPlayer = players[0]; 
					flip = false; //original board
					System.out.println("Current player is player[0] red");
				} 
				
				try {
					if(clickCount == 0) {
						
						//Store first click
						clickStored[0]=c_Flip;
						clickStored[1]=r_Flip;
						clickCount++;
						System.out.println("First Click: " + clickCount);
						
						
						//Show selected JButton 
						String tempColor = boardModel.getSpot(c_Flip, r_Flip).getPiece().getColor();
						boardView.showButtonColor(c ,r, tempColor);
						//Show all possible move at JButton
						if(!boardModel.getSpot(c_Flip, r_Flip).isEmpty()) {
							showAllValidMove(c_Flip, r_Flip, flip, tempColor);
						}
					}
					else if(clickCount == 1) {
						
						//Store second click
						clickStored[2]=c_Flip;
						clickStored[3]=r_Flip;
						clickCount = 0;
						System.out.println("Second Click:"  + clickCount);
						
						//Clear JButton Color 
						//Set all JButton to white color
						boardView.clearButtonColor();	
						
						//Check valid move
						Piece movedPiece = boardModel.getSpot(clickStored[0],clickStored[1]).getPiece();
						boolean isValidPlayerMove = gameWebale.playerMove(currentPlayer, clickStored[0],clickStored[1],clickStored[2],clickStored[3]);
						
						//If player move is valid then 
						// totalMoveCount++, move piece, reset icon
						if(isValidPlayerMove){
							totalMoveCount++;
							System.out.println("total move count:" + totalMoveCount);
							
							//Change Plus to Triangle, vice versa
							changePlusToTriangle();
							
							//move the piece (isCaptured piece = null)
							movedPiece.move(clickStored[0],clickStored[1],clickStored[2],clickStored[3]);
							
							for(int i = 0; i < 50000 ; i++) {} //delay for a while
							boardView.displayBoard(boardModel.getEntireGameBoardSpot(), !flip); //change flip
							boardView.changeSideBar(totalMoveCount, gameWebale.getStatus());
							
							//-------------------------------------------------------------------
							// SAVE GAME MEMENTO
							//-------------------------------------------------------------------
							
							// Set the value for the current memento				
							originator.set(boardModel.getEntireGameBoardSpot(), totalMoveCount);
							
							// Add new article to the ArrayList	
							caretaker.addGameBoardMemento( originator.storeInGameBoardMemento() );
							
							// saveFiles monitors how many articles are saved
							// currentArticle monitors the current article displayed
							
							savedMemento++;
							System.out.println("Saved Memento: " + savedMemento);
							
							// Make undo clickable
							boardView.getUndoButton().setEnabled(true);
							
							//-------------------------------------------------------------------
							// SAVE GAME MEMENTO
							//-------------------------------------------------------------------
							
						}else {
							System.out.println("????? Fail ?????");
						}
						
						//Clear and reset the clickStored array
						Arrays.fill(clickStored, -1);				
						System.out.println("Clear and reset clickStored and Click Count\n\n");
					}
				} catch (Exception e1) {
					System.out.println("Exception: GameBoardController fail actionPerformed\n\n");
				}
			}
			
			else { // undoButton
				System.out.println("\n\nThis is the undo button\n");
				
				if(totalMoveCount > 1){
					
					// Decrement to the current article displayed
					totalMoveCount--;
					
					// Get the older GameBoard saved and display it in screen
					GameBoardSpot[][] tempGameBoardSpot = originator.restoreBoard( caretaker.getMemento(totalMoveCount-1) );
					GameBoardSpot[][] newGameBoardSpot = boardModel.getEntireGameBoardSpot();
					
					System.out.print( "\n********************\n"
									+ " Inside Undo Button" 
									+ "\n********************\n");
					for(int y = 0; y < 8; y++){
						for(int x = 0; x < 7; x++){
							newGameBoardSpot[y][x] = tempGameBoardSpot[y][x];
							if (newGameBoardSpot[y][x].getPiece() == null) {
								System.out.print("null   ");
							} else {
								System.out.print(newGameBoardSpot[y][x].getPiece().getPieceInfo() + " ");
							}
							
						} System.out.print("\n");
					}System.out.print("\n********************\n"
									+ " Outside Undo Button" 
									+ "\n********************\n");
					caretaker.removeGameBoardMemento();
								
					boolean flip = false;
					if (totalMoveCount % 2 == 0) {
						flip = true;
					} else {
						flip = false;
					}
					
					for(int i = 0; i < 50000 ; i++) {} //delay for a while
					boardView.displayBoard(boardModel.getEntireGameBoardSpot(), flip);
					gameWebale.setStatus(GameStatus.ACTIVE);
					boardView.changeSideBar(totalMoveCount, gameWebale.getStatus());
					
				
				} else {
					
					// Don't allow user to click Undo
					boardView.getUndoButton().setEnabled(false);
					
				}
			}
		}
		
		public void showAllValidMove(int startX, int startY, boolean flip, String color) throws Exception {
			for(int y = 0; y < 8; y++){
				for(int x = 0; x < 7; x++){
					if(boardModel.getSpot(startX,startY).getPiece().isValidMove(boardModel, 
							boardModel.getSpot(startX,startY), boardModel.getSpot(x,y))) {
						if(flip) {
							boardView.showButtonColor((6-x),(7-y),color);
						} else {
							boardView.showButtonColor(x,y,color);
						}
					}
				}
			}
		}

		public void changePlusToTriangle() throws Exception {
			if((totalMoveCount - 1) % 4 == 0) {
				for(int y = 0; y < 8; y++){
					for(int x = 0; x < 7; x++){
						if(!boardModel.getSpot(x,y).isEmpty() ){
							if(!boardModel.getSpot(x,y).getPiece().isCaptured()) {
								if(boardModel.getSpot(x,y).getPiece() instanceof Plus 
										|| boardModel.getSpot(x,y).getPiece() instanceof Triangle) {
									boardModel.changePlusAndTriangle(x, y);
								}
							} 
						}
					}
				}
			}
		}
		
		
	}
	

}
