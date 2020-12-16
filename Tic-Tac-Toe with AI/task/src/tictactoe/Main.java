package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TODO: Change it so you can switch to 4x4 or 5x5 (aka dynamic)
// Right now the size is hardcoded

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

                ArrayList<PlayerType> players = new ArrayList<>();

                players.addAll(getPlayerType(input));

                Game game = new Game(players);
                game.nextRound();
                MainMenu();

                break;
            default:
                System.out.println("Bad parameters!");
                MainMenu();
        }


    }

    private static ArrayList<PlayerType> getPlayerType(ArrayList<String> input) {
        ArrayList<PlayerType> players = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            switch (input.get(i)) {
                case "user":
                    players.add(PlayerType.USER);
                    break;
                case "easy":
                    players.add(PlayerType.COMPUTER_EASY);
                    break;
                case "medium":
                    players.add(PlayerType.COMPUTER_MEDIUM);
                    break;
                case "hard":
                    players.add(PlayerType.COMPUTER_HARD);
                    break;
                default:
                    System.out.println("Bad parameters!");
                    MainMenu();
            }
        }
        return players;
    }

}
