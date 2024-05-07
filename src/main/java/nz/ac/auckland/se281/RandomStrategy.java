package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** RandomStrategy class to implement the Random strategy for the AI. */
public class randomStrategy implements Strategy {

  /**
   * Method to get the number of fingers the AI will play on Random strategy.
   *
   * @param playerEvenCount playerEvenCount is the number of times even fingers has been played by
   *     the player.
   * @param playerOddCount playerOddCount is the number of times odd fingers has been played by the
   *     player.
   * @param choice choice is the choice of the player to play even or odd.
   * @return the number of fingers the AI will play.
   */
  @Override
  public int getFingers(int playerEvenCount, int playerOddCount, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
