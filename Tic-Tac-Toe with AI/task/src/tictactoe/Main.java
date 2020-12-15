package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu();
    }

    private static void MainMenu() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> input = new ArrayList<>();

        System.out.print("Input command: ");

        input.add(scanner.next());

        switch (input.get(0)) {
            case "exit":
                return;
            case "start":
                String line = scanner.nextLine();
                line = line.strip();
                input.addAll(Arrays.asList(line.split(" ")));

                if (input.size() != 3) {
                    System.out.println("Bad parameters!");
                    MainMenu();
                }

                PlayerType[] players = new PlayerType[2];

                for (int i = 1; i < 3; i++) {
                    switch (input.get(i)) {
                        case "user":
                            players[i - 1] = PlayerType.USER;
                            break;
                        case "easy":
                            players[i - 1] = PlayerType.COMPUTER_EASY;
                            break;
                        case "medium":
                            players[i - 1] = PlayerType.COMPUTER_MEDIUM;
                            break;
                        case "hard":
                            players[i - 1] = PlayerType.COMPUTER_HARD;
                            break;
                        default:
                            System.out.println("Bad parameters!");
                            MainMenu();
                    }
                }
                Game game = new Game(players);
                game.nextRound();
                MainMenu();

                break;
            default:
                System.out.println("Bad parameters!");
                MainMenu();
        }


    }
}
