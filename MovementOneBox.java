
public class MovementOneBox implements MovementBehavior {

	@Override
	public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction) {
		
		int tempx = end.getX() - start.getX();
    	int tempy = end.getY() - start.getY();

    	if (java.lang.Math.abs(tempx) <= 1 && java.lang.Math.abs(tempy) <= 1)
    	{
    		return true;
    	}
    	else //if it is not the movement rule of Sun
    	{
    		return false;
    		//pop up display "Illegal movement"
    	}
	}

}
