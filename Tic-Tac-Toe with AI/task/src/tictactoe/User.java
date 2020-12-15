package tictactoe;

import java.util.Scanner;

public class User extends Player {

    public User(Board board) {
        super(board);
    }

    @Override
    void nextMove() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates: ");

        int[] input = new int[2];

        for (int i = 0; i < 2; i++) {
            input[i] = getInput(scanner);
            if (input[i] == -1) {
                nextMove();
                return;
            }
        }

        if (!board.checkCell(input[0], input[1])) {
            System.out.println("This cell is occupied! Choose another one!");
            nextMove();
            return;
        }

        board.addCell(input[0], input[1]);
    }

    private static int getInput(Scanner scanner) {
        int value = -1; //means error if returned
        if (!scanner.hasNextInt()) {
            System.out.println(scanner.next()); // WHY?!?
            System.out.println("\nYou should enter numbers!");
            return -1;
        }
        value = scanner.nextInt();

        if (value <= 0 || value >= 4) {
            System.out.println("Coordinates should be from 1 to 3!");
            return -1;
        }

        return value - 1;
    }

}
