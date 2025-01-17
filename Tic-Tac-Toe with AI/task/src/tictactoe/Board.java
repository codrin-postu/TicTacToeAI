package tictactoe;

import java.awt.font.FontRenderContext;

public class Board {
    char[][] boardArray;


    public Board(char[] positions) {
        boardArray = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardArray[i][j] = positions[i * 3 + j];
            }
        }
    }

    public char[] getBoard() {
        char[] board = new char[9];
        int boardPos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[boardPos++] = boardArray[i][j];
            }
        }
        return board;
    }

    public char getCell(int coordX, int coordY) {
        return boardArray[coordX][coordY];
    }

    //Returns true - cell is available; false - cell is occupied;
    public boolean checkCell(int coordX, int coordY) {
        if (boardArray[coordX][coordY] == ' ') {
            return true;
        }
        return false;
    }

    //returns the amount of chosen chars on the board: X, O
    public int getCellCount(char cellType) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardArray[i][j] == cellType) {
                    count++;
                }
            }
        }
        return count;
    }

    public char nextCell() {
        if (getCellCount('X') > getCellCount('O')) {
            return 'O';
        } else {
            return 'X';
        }
    }

    public void addCell(int coordX, int coordY) {
        if (getCellCount('X') > getCellCount('O')) {
            boardArray[coordX][coordY] = 'O';
        } else {
            boardArray[coordX][coordY] = 'X';
        }
    }

    public void addCell(int coordX, int coordY, char cellType) {
        boardArray[coordX][coordY] = cellType;

    }

    public void outputBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " +
                    boardArray[i][0] + " " +
                    boardArray[i][1] + " " +
                    boardArray[i][2] + " " +
                    "|");
        }
        System.out.println("---------");
    }

    public boolean checkBoardStatus() {
        for (int i = 0; i < 3; i++) {
            if (boardArray[i][0] == boardArray[i][1]
                    && boardArray[i][1] == boardArray[i][2]
                    && boardArray[i][0] != ' '
            ) {
                outputBoard();
                System.out.println(boardArray[i][0] + " wins");
                return true;
            }
            if (boardArray[0][i] == boardArray[1][i]
                    && boardArray[1][i] == boardArray[2][i]
                    && boardArray[0][i] != ' '
            ) {
                outputBoard();
                System.out.println(boardArray[0][i] + " wins");
                return true;
            }
        }

        if (boardArray[0][0] == boardArray[1][1]
                && boardArray[1][1] == boardArray[2][2]
                && boardArray[0][0] != ' '
        ) {
            outputBoard();
            System.out.println(boardArray[0][0] + " wins");
            return true;
        }

        if (boardArray[0][2] == boardArray[1][1]
                && boardArray[1][1] == boardArray[2][0]
                && boardArray[0][2] != ' '
        ) {
            outputBoard();
            System.out.println(boardArray[0][2] + " wins");
            return true;
        }

        if (getCellCount('X') + getCellCount('O') == 9) {
            outputBoard();
            System.out.println("Draw");
            return true;
        }

        return false;

    }
}
