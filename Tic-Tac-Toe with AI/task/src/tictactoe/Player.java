package tictactoe;

public abstract class Player {

    protected Board board;

    public Player(Board board) {
        this.board = board;
    }

    abstract void nextMove();
}
