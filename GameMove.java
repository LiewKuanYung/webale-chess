
public class GameMove { 
	private Player player; 
	private GameBoardSpot start; 
	private GameBoardSpot end; 
	private Piece pieceMoved; 
	private Piece pieceKilled;  

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
}
