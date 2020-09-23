import java.util.ArrayList;

public class GameBoardCaretaker {

	// Where all GameBoardMemento are saved
	ArrayList<GameBoardMemento> savedBoardAndMoveCount = new ArrayList<>();

	// Adds GameBoardMemento to the ArrayList
	public void addGameBoardMemento(GameBoardMemento m) { savedBoardAndMoveCount.add(m); }
	
	public void removeGameBoardMemento() { 
		int index = savedBoardAndMoveCount.size()-1;
		savedBoardAndMoveCount.remove(index);}; 

	// Gets the GameBoardMemento requested from the ArrayList
	public GameBoardMemento getMemento(int index) { return savedBoardAndMoveCount.get(index); }
}
