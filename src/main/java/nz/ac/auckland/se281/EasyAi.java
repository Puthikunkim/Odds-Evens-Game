package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** EasyAi class to implement the Easy difficulty of the AI. */
public class EasyAi implements Ai {

  /**
   * Method to get the number of fingers the AI will play on Easy difficulty.
   *
   * @param roundNumber roundNumber is the number of the round.
   * @param playerEvenCount playerEvenCount is the number of times even fingers has been played by
   *     the player.
   * @param playerOddCount playerOddCount is the number of times odd fingers has been played by the
   *     player.
   * @param choice choice is the choice of the player to play even or odd.
   * @param playerWinRound playerWinRound is a boolean to determine if the player won the previous
   *     round.
   * @param strategy strategy is the strategy to be used by the AI whether the Random or Top
   *     strategy (used only for Hard difficulty).
   * @return the number of fingers the AI will play.
   */
  @Override
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy) {

    // AI uses the Random strategy
    Order order = new Order(playerEvenCount, playerOddCount, choice, new randomStrategy());
    int fingers = order.fingersProcess();

    // Print the number of fingers the AI played
    String infoHandMessage =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(infoHandMessage);
    return fingers;
  }
}
