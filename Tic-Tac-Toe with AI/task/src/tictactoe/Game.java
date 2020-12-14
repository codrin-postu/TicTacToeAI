package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<Player> players;
    Board board;

    public Game(PlayerType[] players) {

        char[] cells = new char[9];

        for (int i = 0; i < 9; i++) {
            cells[i] = ' ';
        }

        board = new Board(cells);

        this.players = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            switch (players[i]) {
                case COMPUTER:
                    this.players.add(new Computer(board, Difficulty.EASY));
                    break;
                case USER:
                    this.players.add(new User(board));
                    break;
            }
        }
    }

    public void nextRound() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            board.outputBoard();
            players.get(i).nextMove();

            if (board.checkBoardStatus()) {
                return;
            }
        }

        nextRound();

    }
}
