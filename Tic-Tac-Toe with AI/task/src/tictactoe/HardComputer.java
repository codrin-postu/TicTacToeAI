package tictactoe;

import java.util.Objects;

public class HardComputer extends Computer {

    int bestRow;
    int bestCol;

    public HardComputer(Board board) {
        super(board);
        difficulty = Difficulty.HARD;
        bestCol = bestRow = -1;
    }

    @Override
    public void nextMove() {
        System.out.println("Making move level \"" + difficulty.getDifficulty() +"\"");
        char userCellType = board.nextCell();
        char opponentCellType = userCellType == 'X' ? 'O' : 'X';
        int xPos, yPos;

        int bestVal = -1000;
        bestRow = -1;
        bestCol = -1;

        Board currBoard = new Board(board.getBoard());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if cell is empty
                if (currBoard.getCell(i, j) == ' ') {
                    // Make the move
                    currBoard.addCell(i, j, userCellType);

                    int moveVal = minimax(currBoard, 0, false, userCellType, opponentCellType);

                    // Undo the move
                    currBoard.addCell(i, j, ' ');

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal) {
                        bestRow = i;
                        bestCol = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        System.out.printf("The value of the best Move " +
                "is : %d - row %d - col %d\n\n", bestVal, bestRow, bestCol);

        if (bestCol >= 0 && bestRow >= 0) {
            board.addCell(bestRow, bestCol);
        } else {
            randomMove();
        }
    }

    private void randomMove() {
        int xPos, yPos;

        do {
            xPos = getRandomNumber(0, 3);
            yPos = getRandomNumber(0, 3);
        } while (!board.checkCell(xPos, yPos));

        board.addCell(xPos, yPos);
    }

    static int minimax(Board currBoard,
                       int depth, Boolean isMax, char userCellType, char opponentCellType) {
        int score = evaluate(currBoard, userCellType, opponentCellType);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score - depth;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score + depth;

        // If there are no more moves and
        // no winner then it is a tie
        if (currBoard.getCellCount(' ') == 0)
            return 0;

        // If this maximizer's move
        if (isMax) {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (currBoard.getCell(i, j) == ' ') {
                        // Make the move
                        currBoard.addCell(i, j, userCellType);

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(currBoard,
                                depth + 1, !isMax, userCellType, opponentCellType));

                        // Undo the move
                        currBoard.addCell(i, j, ' ');
                    }
                }
            }
            return best;
        }

        else {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if cell is empty
                    if (currBoard.getCell(i, j) == ' ') {
                        // Make the move
                        currBoard.addCell(i, j, opponentCellType);

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(currBoard,
                                depth + 1, !isMax, userCellType, opponentCellType));

                        // Undo the move
                        currBoard.addCell(i, j, ' ');
                    }
                }
            }
            return best;
        }
    }

    // This is the evaluation function as discussed
    static int evaluate(Board currBoard, char player, char opponent) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (currBoard.getCell(row, 0) == currBoard.getCell(row, 1) &&
                    currBoard.getCell(row, 1) == currBoard.getCell(row, 2)) {
                if (currBoard.getCell(row, 0) == player)
                    return +10;
                else if (currBoard.getCell(row, 0) == opponent)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (currBoard.getCell(0, col) == currBoard.getCell(1, col) &&
                    currBoard.getCell(1, col) == currBoard.getCell(2, col)) {
                if (currBoard.getCell(0, col) == player)
                    return +10;

                else if (currBoard.getCell(0, col) == opponent)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (currBoard.getCell(0, 0) == currBoard.getCell(1, 1) &&
                currBoard.getCell(1, 1) == currBoard.getCell(2, 2)) {
            if (currBoard.getCell(0, 0) == player)
                return +10;
            else if (currBoard.getCell(0, 0) == opponent)
                return -10;
        }

        if (currBoard.getCell(0, 2) == currBoard.getCell(1, 1) &&
                currBoard.getCell(1, 1) == currBoard.getCell(2, 0)) {
            if (currBoard.getCell(0, 2) == player)
                return +10;
            else if (currBoard.getCell(0, 2) == opponent)
                return -10;
        }

        return 0;
    }


}
