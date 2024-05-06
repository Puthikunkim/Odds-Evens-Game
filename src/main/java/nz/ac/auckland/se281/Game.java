package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private int playerEvenCount;
  private int playerOddCount;
  private boolean playerWinRound;
  private String[] options;
  private Difficulty difficulty;
  private Choice choice;
  private String hardStrategy;
  private boolean gameStart;
  private int playerWins;
  private int aiWins;

  /**
   * This method starts a new game.
   *
   * @param difficulty difficulty of the game
   * @param choice choice of the player (even or odd)
   * @param options name of the player
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.difficulty = difficulty;
    this.choice = choice;
    this.options = options;
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    // Sets round number for a new game
    this.roundNumber = 1;
    this.playerEvenCount = 0;
    this.playerOddCount = 0;
    this.playerWinRound = false;
    this.hardStrategy = "Random";
    this.gameStart = true;
    this.playerWins = 0;
    this.aiWins = 0;
  }

  /** This method plays a round of the game. */
  public void play() {
    // Check if the game has started
    if (!gameStart) {
      System.out.println(MessageCli.GAME_NOT_STARTED.getMessage());
      return;
    }
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
        String infoHandMessage = MessageCli.PRINT_INFO_HAND.getMessage(options[0], input);
        System.out.println(infoHandMessage);
        break;
      } else {
        System.out.println(MessageCli.INVALID_INPUT.getMessage());
        input = Utils.scanner.nextLine();
      }
    }
    // Get AI fingers
    Ai ai = AiFactory.createAi(difficulty);
    int aiFingers =
        ai.getFingers(
            roundNumber, playerEvenCount, playerOddCount, choice, playerWinRound, hardStrategy);
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
      String roundOutcomeMessage =
          MessageCli.PRINT_OUTCOME_ROUND.getMessage(
              String.valueOf(sum), sumType.toUpperCase(), options[0]);
      System.out.println(roundOutcomeMessage);
      playerWinRound = true;
    } else {
      String roundOutcomeMessage =
          MessageCli.PRINT_OUTCOME_ROUND.getMessage(
              String.valueOf(sum), sumType.toUpperCase(), "HAL-9000");
      System.out.println(roundOutcomeMessage);
      playerWinRound = false;
    }
    // Increment player finger type choice
    if (Utils.isEven(Integer.parseInt(input))) {
      playerEvenCount++;
    } else {
      playerOddCount++;
    }
    // Logic to determine what strategy to use in the next round for hard ai after round 3
    if (difficulty == Difficulty.HARD && roundNumber > 3) {
      if (playerWinRound) {
        if (hardStrategy.equals("Random")) {
          hardStrategy = "Top";
        } else if (hardStrategy.equals("Top")) {
          hardStrategy = "Random";
        }
      } else if (!playerWinRound) {
        if (hardStrategy.equals("Random")) {
          hardStrategy = "Random";
        } else if (hardStrategy.equals("Top")) {
          hardStrategy = "Top";
        }
      }
    }
    // Increment player wins
    if (playerWinRound) {
      playerWins++;
    } else {
      aiWins++;
    }
    // Increment round number with each play call
    roundNumber++;
  }

  /** This method ends the game and prints the final message. */
  public void endGame() {
    if (!gameStart) {
      System.out.println(MessageCli.GAME_NOT_STARTED.getMessage());
      return;
    } else {
      // Print the final message
      if (playerWins > aiWins) {
        String endMessage = MessageCli.PRINT_END_GAME.getMessage(options[0]);
        showStats();
        System.out.println(endMessage);
      } else if (playerWins < aiWins) {
        String endMessage = MessageCli.PRINT_END_GAME.getMessage("HAL-9000");
        showStats();
        System.out.println(endMessage);
      } else if (playerWins == aiWins) {
        String endMessage = MessageCli.PRINT_END_GAME_TIE.getMessage();
        showStats();
        System.out.println(endMessage);
      }
      // Reset the game and stats
      gameStart = false;
    }
  }

  /** This method shows the stats of the game. */
  public void showStats() {
    // Check if the game has started
    if (!gameStart) {
      System.out.println(MessageCli.GAME_NOT_STARTED.getMessage());
      return;
    } else {
      // Print the stats for player and ai
      String printPlayerStats =
          MessageCli.PRINT_PLAYER_WINS.getMessage(
              options[0], String.valueOf(playerWins), String.valueOf(aiWins));
      System.out.println(printPlayerStats);
      String printAiStats =
          MessageCli.PRINT_PLAYER_WINS.getMessage(
              "HAL-9000", String.valueOf(aiWins), String.valueOf(playerWins));
      System.out.println(printAiStats);
    }
  }
}
