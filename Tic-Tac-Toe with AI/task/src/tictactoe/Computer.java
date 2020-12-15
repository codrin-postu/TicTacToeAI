package tictactoe;

public abstract class Computer extends Player {

    Difficulty difficulty;

    public Computer(Board board) {
        super(board);
    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
