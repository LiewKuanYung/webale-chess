
public class GameMove { 
	private Player player; 
	private GameBoardSpot start; 
	private GameBoardSpot end; 
	private Piece pieceMoved; 
	private Piece pieceKilled; 
	private boolean castlingMove = false; 

	public GameMove(Player player, GameBoardSpot start, GameBoardSpot end) 
	{ 
		this.player = player; 
		this.start = start; 
		this.end = end; 
		this.pieceMoved = start.getPiece(); 
	} 
}
