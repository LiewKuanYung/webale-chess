// by Liew Kuan Yung
interface MovementBehavior
{
    public boolean checkValidMove(GameBoard board, GameBoardSpot start, GameBoardSpot end, boolean direction);
}