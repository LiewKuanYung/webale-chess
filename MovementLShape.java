
public class MovementLShape implements MovementBehavior {

	@Override
	public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction) {
		
		
    	int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();
    	int checktempx = java.lang.Math.abs(tempx);
    	int checktempy = java.lang.Math.abs(tempy);
    	if (checktempx == 1 && checktempy == 2 || checktempx == 2 && checktempy == 1)
    	{
    		return true;
    	}
    	else //if it is not the movement rule of Chevron
    	{
    		return false;
    		//pop up display "Illegal movement"
    	}
	}

}
