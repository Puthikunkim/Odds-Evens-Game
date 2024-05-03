package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;

  private String[] options;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.options = options;
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Sets round number for a new game
    roundNumber = 1;
    System.out.println(roundNumber);
  }

  public void play() {
    // Round message
    String round_message = MessageCli.START_ROUND.getMessage(String.valueOf(roundNumber));
    System.out.println(round_message);
    // Ask player for fingers
    String ask_input = MessageCli.ASK_INPUT.getMessage();
    System.out.println(ask_input);
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
    roundNumber++;
  }

  public void endGame() {}

  public void showStats() {}
}
