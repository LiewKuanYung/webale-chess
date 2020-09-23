
public enum GameStatus {
	
	ACTIVE(1),
	DRAW(2),
	RED_WIN(3),
	BLUE_WIN(4);
	
	private int statusValue;  
	private GameStatus(int statusValue){  
	this.statusValue=statusValue;  
	}  
}
