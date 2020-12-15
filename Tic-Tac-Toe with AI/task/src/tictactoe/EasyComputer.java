package tictactoe;

public class EasyComputer extends Computer {

    public EasyComputer(Board board) {
        super(board);
        difficulty = Difficulty.EASY;
    }

    @Override
    public void nextMove() {
        int xPos, yPos;

        System.out.println("Making move level \"" + difficulty.getDifficulty() + "\"");

        do {
            xPos = getRandomNumber(0, 3);
            yPos = getRandomNumber(0, 3);
        } while (!board.checkCell(xPos, yPos));

        board.addCell(xPos, yPos);

    }
}
