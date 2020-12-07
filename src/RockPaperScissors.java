import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    // Funktion som kollar om inputen är rock, paper eller scissor.
    public static boolean checkRockPaperScissor(String input) {
        if (input.equals("rock") || input.equals("paper") || input.equals("scissor")) {
            return true;
        } else {
            return false;
        }
    }

    // Funktion som omvandlar ett slumpmässigt nummer mellan 1 och 3 till rock, paper eller scissor.
    public static String convertNumberToRockPaperScissor(int num) {
        if (num == 1) {
            return "rock";
        } else if (num == 2) {
            return "paper";
        } else if (num == 3) {
            return "scissor";
        } else {
            return "Wrong input";
        }
    }

    // Funktion som tar in två parametrar och returnar vinnaren.
    public static String chooseWinner(String value, String value2) {
        if (value.equals("rock") && value2.equals("paper") || value2.equals("rock") && value.equals("paper")) {
            return "Paper beats rock!";
        } else if (value.equals("paper") && value2.equals("scissor") || value2.equals("paper") && value.equals("scissor")) {
            return "Scissor beats paper!";
        } else if (value.equals("scissor") && value2.equals("rock") || value2.equals("scissor") && value.equals("rock")) {
            return "Rock beats scissors!";
        } else {
            return "It was a draw.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPlayers = 0;
        Random random = new Random();

        System.out.println("Welcome to Rock Paper Scissors simulator.");

        // While loop som ska bestämma om det är en eller två spelare.
        boolean numOfPlayersChoosen = false;
        while (!numOfPlayersChoosen) {
            System.out.println("Type '1' or '2' to choose how many players.");

            int numOfPlayersInput;
            try {
                numOfPlayersInput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            if (numOfPlayersInput == 1) {
                System.out.println("You choose 1 player.");
                numOfPlayers = 1;
                numOfPlayersChoosen = true;
            } else if (numOfPlayersInput == 2) {
                System.out.println("You choose 2 players.");
                numOfPlayers = 2;
                numOfPlayersChoosen = true;
            } else {
                System.out.println("Input invalid, please type '1' or '2'.");
                continue;
            }
        }

        // While loop som bestämmer spelarnas val och utser en vinnare.
        while (true) {
            if (numOfPlayers == 1) {
                System.out.println("Choose rock, paper or scissor.");
                String choice = scanner.nextLine();

                if (!checkRockPaperScissor(choice)) {
                    System.out.println("Wrong input");
                    continue;
                }

                int randomNum = random.nextInt(3 - 1 + 1) + 1;
                String botChoice = convertNumberToRockPaperScissor(randomNum);

                System.out.println("You chose " + choice + ", your opponent chose " + botChoice + ".");
                System.out.println(chooseWinner(choice, botChoice));

                System.out.println("Do you want to play again? If so type 'yes'. If not, press enter.");
                String playAgain = scanner.nextLine();

                if (playAgain.equals("yes")) {
                    continue;
                } else {
                    break;
                }

            } else if (numOfPlayers == 2) {
                System.out.println("Can player 1 choose rock, paper or scissor.");
                String playerOneInput = scanner.nextLine();
                if (!checkRockPaperScissor(playerOneInput)) {
                    System.out.println("Wrong input");
                    continue;
                }

                System.out.println("Can player 2 choose rock, paper or scissor.");
                String playerTwoInput = scanner.nextLine();
                if (!checkRockPaperScissor(playerTwoInput)) {
                    System.out.println("Wrong input");
                    continue;
                }

                System.out.println("Player 1 chose " + playerOneInput + ", player 2 chose " + playerTwoInput + ".");
                System.out.println(chooseWinner(playerOneInput, playerTwoInput));

                System.out.println("Do you want to play again? If so type 'yes'. If not, press enter.");
                String playAgain = scanner.nextLine();

                if (playAgain.equals("yes")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
