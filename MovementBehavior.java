/**
 * @author Liew Kuan Yung 
 */

// GOF Strategy Design Pattern
interface MovementBehavior
{
    public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction);
}