import java.util.*;

public class GameWebale {
	
	private Player[] players = new Player[2];
	private GameBoard board; 
	private Player currentTurn; 
	private ArrayList<GameMove> gameMovesPlayed = new ArrayList<GameMove>(); 
	
	GameWebale(GameBoard board, Player p1, Player p2){
		this.board = board;
		initialize(p1, p2);
	}
	
	private void initialize(Player p1, Player p2) 
	{ 
		players[0] = p1; 
		players[1] = p2; 

		board.resetBoard(); 

		if (p1.isColorRed()) { //Red Start First
			System.out.println("Current Player Check Point p1");
			this.currentTurn = p1; 
		} 
		else {
			System.out.println("Current Player Check Point p2");
			this.currentTurn = p2; 
		} 

		gameMovesPlayed.clear(); 
	} 
	
	public Player getCurrentPlayer() {
		return currentTurn;
	}


	public boolean playerMove(Player player, int startX, int startY, 
			int endX, int endY) 
	{ 
		System.out.println("Check point playerMove 1: start xy "+ startX + " "+ startY + " end xy " + endX + " " + endY);
		GameBoardSpot startBox = null;
		GameBoardSpot endBox = null;
		try {
			startBox = board.getSpot(startX, startY);
			endBox = board.getSpot(endX, endY);
		} catch (Exception e) {
			System.out.println("Exception: GameWebale");
		} 
		System.out.println("Check Point playerMove 2 getSpot success");
		
		GameMove move = new GameMove(player, startBox, endBox); 
		System.out.println("Check Point playerMove 3 GameMove Saved");
		return this.makeMove(move, player); 
	} 
	
	private boolean makeMove(GameMove move, Player player) 
	{ 
		System.out.println("Check Point: inside make move");
		
		Piece startPiece = move.getStart().getPiece(); 
		if (startPiece == null) { 
			System.out.println("null start piece");
			return false; 
		} 
		System.out.println("Check Point 4 pass startPiece test");
	
		/* check valid player? 
		if (player != currentTurn) { 
			System.out.println("invalide current player");
			return false; 
		} /**/
		
		if (startPiece.getColor() != player.getColor()) { 
			System.out.println("invalid current player (color)");
			return false; 
		} 
	
		System.out.println("Check Point 5 pass color test");
		
		// check valid move? 
		if (!startPiece.isValidMove(board, move.getStart(), move.getEnd())) { 
			System.out.println("invalid move");
			return false; 
		} 
		
		System.out.println("Check Point 6 pass isValidMove");
		
		// check any capture? 
		Piece endPiece = move.getStart().getPiece(); 
		if (endPiece != null) { 
			endPiece.setCaptured(true); 
			move.setPieceKilled(endPiece); 
		} 
		
		System.out.println("Check Point 7 checked captured");
		
		// store the move 
		gameMovesPlayed.add(move); 
		
		if (endPiece != null && endPiece instanceof Sun) { 
			if (player.isColorRed()) { 
				System.out.println("Red Lost");
				//this.setStatus(GameStatus.WHITE_WIN); 
			} 
			else {
				System.out.println("Blue Lost");
				//this.setStatus(GameStatus.BLACK_WIN); 
			} 
		} 
		
		
		// move piece from the start box to end box 
		move.getEnd().setPiece(move.getStart().getPiece()); 
		move.getStart().setPiece(null); 
		System.out.println("Check Point 8 reset pieces");
		
		// set the current turn to the other player 
		if (this.currentTurn == players[0]) { 
			System.out.println("Change current player to player[1]");
			this.currentTurn = players[1]; 
		} 
		else { 
			System.out.println("Change current player to player[0]");
			this.currentTurn = players[0]; 
		} 
		
		System.out.println("!!!Successful Move!!!");
		return true; 
	} 
		
}
