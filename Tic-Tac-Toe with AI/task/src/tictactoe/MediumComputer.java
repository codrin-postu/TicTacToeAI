package tictactoe;

public class MediumComputer extends Computer {

    public MediumComputer(Board board) {
        super(board);
        difficulty = Difficulty.MEDIUM;
    }

    @Override
    public void nextMove() {
        System.out.println("Making move level \"medium\"");

        char userCellType = board.nextCell();
        char opponentCellType = userCellType == 'X' ? 'O' : 'X';

        if (verifyMove(userCellType)) {
            return;
        }

        if (verifyMove(opponentCellType)) {
            return;
        }

        randomMove();

    }

    private void randomMove() {
        System.out.println("Random move!");
        int xPos, yPos;

        do {
            xPos = getRandomNumber(0, 3);
            yPos = getRandomNumber(0, 3);
        } while (!board.checkCell(xPos, yPos));

        board.addCell(xPos, yPos);

    }

    //Checks if it has moves where it can win. If it does, it will add the cell and return true.
    //TODO: Change all the if's to something more readable
    private boolean verifyMove(char cellType) {
        System.out.println("Move made based on other placements!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j) == ' ') {
                    if (checkRow(i, j, cellType) || checkCollumn(i, j, cellType)) {
                        board.addCell(i, j);
                        return true;
                    }
                    if (Math.abs(i - j) == 0 && i + j == 2) {
                        if (checkPrimaryDiagonal(i, cellType) || checkSecondaryDiagonal(i, cellType)) {
                            board.addCell(i, j);
                            return true;
                        }
                    } else if (Math.abs(i - j) == 0) {
                        if (checkPrimaryDiagonal(i, cellType)) {
                            board.addCell(i, j);
                            return true;
                        }
                    } else if (i + j == 2) {
                        if (checkSecondaryDiagonal(i, cellType)) {
                            board.addCell(i, j);
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    private boolean checkRow(int xCoord, int yCoord, char cellType) {
        var sameCellCount = 0;

        for (int i = 0; i < 3; i++) {
            if (cellType == board.getCell(xCoord, i) && i != yCoord) {
                sameCellCount++;
            }
        }
        if (sameCellCount == 2) {
            return true;
        }
        return false;
    }

    private boolean checkCollumn(int xCoord, int yCoord, char cellType) {
        var sameCellCount = 0;

        for (int i = 0; i < 3; i++) {
            if (cellType == board.getCell(i, yCoord) && i != xCoord) {
                sameCellCount++;
            }
        }
        if (sameCellCount == 2) {
            return true;
        }
        return false;
    }

    private boolean checkSecondaryDiagonal(int xCoord, char cellType) {
        var sameCellCount = 0;

        for (int i = 0; i < 3; i++) {
            if (cellType == board.getCell(i, 3 - i - 1) && i != xCoord) {
                sameCellCount++;
            }
        }
        if (sameCellCount == 2) {
            return true;
        }
        return false;
    }

    private boolean checkPrimaryDiagonal(int xCoord, char cellType) {
        var sameCellCount = 0;

        for (int i = 0; i < 3; i++) {
            if (cellType == board.getCell(i, i) && i != xCoord) {
                sameCellCount++;
            }
        }
        if (sameCellCount == 2) {
            return true;
        }
        return false;
    }
}
