package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Strategy interface to be implemented by the different strategies of the AI. */
public interface Strategy {

  /**
   * Method to get the number of fingers the AI will play either on Random or Top Strategy (abstract
   * method).
   *
   * @param playerEvenCount playerEvenCount is the number of times even fingers has been played by
   *     the player.
   * @param playerOddCount playerOddCount is the number of times odd fingers has been played by the
   *     player.
   * @param choice choice is the choice of the player to play even or odd.
   * @return the number of fingers the AI will play.
   */
  public int getFingers(int playerEvenCount, int playerOddCount, Choice choice);
}
