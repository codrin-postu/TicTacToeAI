package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        prepareGame();
    }

    private static void prepareGame() {
        Scanner scanner = new Scanner(System.in);
        char[] cells = new char[9];

        System.out.print("Enter the cells: ");

        String input = scanner.next();


        //Example does not assume for the input being different that the requested 9 chars
        //Will add such validation in future.
        for (int i = 0; i < 9; i++) {
            cells[i] = input.charAt(i);

            if (cells[i] == '_') {
                cells[i] = ' ';
            }
        }

        Board game = new Board(cells);

        game.outputBoard();

        startGame(game);
    }

    private static void startGame(Board game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");

        int[] input = new int[2];

        for (int i = 0; i < 2; i++) {
            input[i] = getInput(scanner);
            if (input[i] == -1) {
                startGame(game);
                return;
            }
        }

        if (!game.checkCell(input[0], input[1])) {
            System.out.println("This cell is occupied! Choose another one!");
            startGame(game);
            return;
        }

        game.addCell(input[0],input[1]);

        game.outputBoard();
        game.checkBoardStatus();

    }

    private static int getInput(Scanner scanner) {
        int value = -1; //means error if returned
        if (!scanner.hasNextInt()) {
            System.out.println("You should enter numbers!");
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
