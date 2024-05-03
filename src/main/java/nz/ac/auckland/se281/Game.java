package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Sets round number for a new game
    roundNumber = 1;
  }

  public void play() {
    // Round message
    String round_message = MessageCli.START_ROUND.getMessage(String.valueOf(roundNumber));
    System.out.println(round_message);
    // Ask player for fingers
    String ask_input = MessageCli.ASK_INPUT.getMessage();
    System.out.println(ask_input);
  }

  public void endGame() {}

  public void showStats() {}
}
