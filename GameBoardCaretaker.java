/**
 * @author Liew Kuan Yung
 */
import java.util.ArrayList;

public class GameBoardCaretaker {

	// Where all GameBoardMemento are saved
	ArrayList<GameBoardMemento> savedBoardAndMoveCount = new ArrayList<>();

	// Adds GameBoardMemento to the ArrayList
	public void addGameBoardMemento(GameBoardMemento m) { savedBoardAndMoveCount.add(m); }
	
	// remove the last GameBoardMemento (first in last out)
	public void removeGameBoardMemento() { 
		int index = savedBoardAndMoveCount.size()-1;
		savedBoardAndMoveCount.remove(index);
	};
	
	// clear the entire GameBoardMemento ArrayList
	public void clearGameBoardMemento() {savedBoardAndMoveCount.clear();};

	// Gets the GameBoardMemento requested from the ArrayList
	public GameBoardMemento getMemento(int index) { return savedBoardAndMoveCount.get(index); }
}
