/**
 * @author Liew Kuan Yung
 */

import java.util.*;
//By Liew Kuan Yung
public class GameWebale {
	
	private Player[] players = new Player[2];
	private Player currentTurn; 
	private GameBoard board; 
	private GameStatus status;
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
			System.out.println("Initialize current Player to p1 Red");
			this.currentTurn = p1; 
		} 
		else {
			System.out.println("Initialize current Player to p2 Blue");
			this.currentTurn = p2; 
		} 
		gameMovesPlayed.clear(); 
		status = GameStatus.ACTIVE;
		
	} 
	
	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public boolean playerMove(Player player, int startX, int startY, 
			int endX, int endY) 
	{ 
		GameBoardSpot startBox = null;
		GameBoardSpot endBox = null;
		try {
			//check game status
			if( status != GameStatus.ACTIVE) {
				return false;
			}
			System.out.println("Game status is not ACTIVE");
			
			//initialize startBox and endBox
			startBox = board.getSpot(startX, startY);
			System.out.println("playerMove: start xy "+ startX + " "+ startY);
			if(startBox.getPiece() == null) {
				System.out.println("Empty");
			} else {
				System.out.println(startBox.getPiece().getPieceInfo());
			}
			endBox = board.getSpot(endX, endY);
			System.out.println("playerMove: end xy " + endX + " " + endY);
			if(endBox.getPiece() == null) {
				System.out.println("Empty");
			} else {
				System.out.println(endBox.getPiece().getPieceInfo());
			}
		} catch (Exception e) {
			System.out.println("Exception: GameWebale");
		} 
		
		GameMove move = new GameMove(player, startBox, endBox); 
		System.out.println("playerMove GameMove Saved");
		return this.makeMove(move, player); 
	} 
	
	private boolean makeMove(GameMove move, Player player) 
	{ 
		System.out.println("Check Point: inside make move");
		
		Piece startPiece = move.getStart().getPiece(); 
		if (startPiece == null) { 
			System.out.println("invalid null start piece");
			return false; 
		} 
		System.out.println("Check Point 1 pass startPiece not null test");
	
		// check valid player? 
		if (startPiece.getColor() != player.getColor()) { 
			System.out.println("invalid current player (color)");
			return false; 
		} 
		System.out.println("Check Point 2 pass color and player test");
		
		// check valid move? 
		if (!startPiece.isValidMove(board, move.getStart(), move.getEnd())) { 
			System.out.println("invalid move");
			return false; 
		} 
		System.out.println("Check Point 3 pass isValidMove test");
		
		// check any capture? 
		Piece endPiece = move.getEnd().getPiece(); 
		if (endPiece != null) { 
			endPiece.setCaptured(true); 
			move.setPieceCaptured(endPiece); 
		} 
		System.out.println("Check Point 4 checked captured and stored in GameMove");
		
		// store the move 
		gameMovesPlayed.add(move); 
		
		if (endPiece != null && endPiece instanceof Sun) { 
			System.out.println(endPiece.getPieceInfo());
			if (player.isColorRed()) { 
				System.out.println("BLUE WIN");
				this.setStatus(GameStatus.BLUE_WIN); 
			} 
			else {
				System.out.println("RED WIN");
				this.setStatus(GameStatus.RED_WIN); 
			} 
		}
		
		// move piece from the start box to end box 
		move.getEnd().setPiece(move.getStart().getPiece()); 
		move.getStart().setPiece(null); 
		System.out.println("Check Point 5 reset pieces in GameMove");
		
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
