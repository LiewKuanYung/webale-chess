/**
 * @author Liew Kuan Yung
 * @ID 1191301064
 */

// GOF Strategy Design Pattern
interface MovementBehavior
{
    public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction);
}