package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private String[] options;
  private Difficulty difficulty;
  private Choice choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.options = options;
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Sets round number for a new game
    roundNumber = 1;
    System.out.println(roundNumber);
  }

  public void play() {
    // Round message
    String roundMessage = MessageCli.START_ROUND.getMessage(String.valueOf(roundNumber));
    System.out.println(roundMessage);
    // Ask player for fingers
    String askInput = MessageCli.ASK_INPUT.getMessage();
    System.out.println(askInput);
    // Get player input
    String input = Utils.scanner.nextLine();
    while (true) {
      if (input.matches("[0-5]")) {
        String print_info_hand = MessageCli.PRINT_INFO_HAND.getMessage(options[0], input);
        System.out.println(print_info_hand);
        break;
      } else {
        System.out.println(MessageCli.INVALID_INPUT.getMessage());
        input = Utils.scanner.nextLine();
      }
    }
    // Get AI fingers
    int aiFingers = 0;
    if (difficulty == Difficulty.EASY) {
      Ai ai = AiFactory.createAi(difficulty);
      aiFingers = ai.getFingers();
    }
    // THis code block is giving errors
    // Calculate the sum of fingers
    int sum = Integer.parseInt(input) + aiFingers;
    // Check if the sum is even or odd and print the outcome
    String sumType = "";
    if (Utils.isEven(sum)) {
      sumType = "even";
    } else {
      sumType = "odd";
    }
    // Print the outcome of the round taking into account user choice
    if ((sumType.equals("even") && choice == Choice.EVEN)
        || (sumType.equals("odd") && choice == Choice.ODD)) {
      String print_outcome_round =
          MessageCli.PRINT_OUTCOME_ROUND.getMessage(
              String.valueOf(sum), sumType.toUpperCase(), options[0]);
      System.out.println(print_outcome_round);
    } else {
      String print_outcome_round =
          MessageCli.PRINT_OUTCOME_ROUND.getMessage(
              String.valueOf(sum), sumType.toUpperCase(), "HAL-9000");
      System.out.println(print_outcome_round);
    }
    roundNumber++;
  }

  public void endGame() {}

  public void showStats() {}
}
