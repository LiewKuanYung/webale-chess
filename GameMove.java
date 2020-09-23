/**
 * @author Liew Kuan Yung
 * @ID 1191301064
 */


public class GameMove { 
	private Player player; 
	private GameBoardSpot start; 
	private GameBoardSpot end; 
	private Piece pieceMoved; 
	private Piece pieceCaptured;  

	public GameMove(Player player, GameBoardSpot start, GameBoardSpot end) 
	{ 
		this.player = player; 
		this.start = start; 
		this.end = end; 
		this.pieceMoved = start.getPiece(); 
	} 
	
	public GameBoardSpot getStart() {
		return start;
	}
	
	public GameBoardSpot getEnd() {
		return end;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Piece getPieceMoved() {
		return pieceMoved;
	}
	
	public void setPieceCaptured(Piece piece) {
		this.pieceCaptured = piece;
	}
	
	public Piece getPieceCaptured() {
		return pieceCaptured;
	}
	
	public String getGameMoveInfo() {
		return pieceMoved.getPieceInfo() + end.getX() + end.getY();
	}
}
