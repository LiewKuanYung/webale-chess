import javax.swing.JButton;

class GameBoardButton extends JButton {
	
	private int x;
    private int y;

    public GameBoardButton(String text, int x, int y) {
        super(text);
        this.x = x;
        this.y = y;
        System.out.println("Check point 1");
    }

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }
}
