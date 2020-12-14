package tictactoe;

public class Computer extends Player {

    Difficulty mode;

    public Computer(Board board, Difficulty mode) {
        super(board);
        this.mode = mode;
    }

    @Override
    public void nextMove() {
        int xPos, yPos;

        System.out.println("Making move level \"" + mode.getDifficulty() + "\"");

        do {
            xPos = getRandomNumber(0, 3);
            yPos = getRandomNumber(0, 3);
        } while (!board.checkCell(xPos, yPos));

        board.addCell(xPos, yPos);

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
