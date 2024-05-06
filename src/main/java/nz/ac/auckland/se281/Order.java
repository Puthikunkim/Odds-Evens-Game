package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Order class to order which strategy to be used by the AI. */
public class Order {
  private int playerEvenCount;
  private int playerOddCount;
  private Choice choice;
  private Strategy strategy;

  /**
   * Constructor for Order used to order which strategy to be used by the AI.
   *
   * @param playerEvenCount playerEvenCount is the number of times even fingers has been played by
   *     the player.
   * @param playerOddCount playerOddCount is the number of times odd fingers has been played by the
   *     player.
   * @param choice choice is the choice of the player to play even or odd.
   * @param strategy strategy is the strategy to be used by the AI whether the Random or Top
   *     strategy.
   */
  public Order(int playerEvenCount, int playerOddCount, Choice choice, Strategy strategy) {
    this.playerEvenCount = playerEvenCount;
    this.playerOddCount = playerOddCount;
    this.choice = choice;
    this.strategy = strategy;
  }

  /**
   * Method to set the strategy to be used by the AI.
   *
   * @param strategy strategy is the strategy to be used by the AI whether the Random or Top
   *     strategy.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Method to get the number of fingers the AI will play.
   *
   * @return the number of fingers the AI will play.
   */
  public int fingersProcess() {
    return strategy.getFingers(playerEvenCount, playerOddCount, choice);
  }
}
