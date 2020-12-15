package tictactoe;

public class HardComputer extends Computer {

    public HardComputer(Board board) {
        super(board);
        difficulty = Difficulty.HARD;
    }

    @Override
    public void nextMove() {
        int xPos, yPos;

        System.out.println("Making move level \"easy\"");

        do {
            xPos = getRandomNumber(0, 3);
            yPos = getRandomNumber(0, 3);
        } while (!board.checkCell(xPos, yPos));

        board.addCell(xPos, yPos);

    }
}
