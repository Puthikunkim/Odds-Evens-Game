package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** TopStrategy class to implement the Top Strategy. */
public class TopStrategy implements Strategy {

  /**
   * Method to get the number of fingers the AI will play on Top Strategy.
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

    int fingers = 0;
    // If the player chose even: If the number of even fingers played by the player is greater than
    // the number of odd let the AI play an odd number. If the number of odd fingers played by the
    // player is greater than the number of even let the AI play an even number. If the number of
    // even fingers played by the player is equal to the number of odd let the AI play a random
    // number.
    if (choice == Choice.EVEN) {
      if (playerEvenCount > playerOddCount) {
        fingers = Utils.getRandomOddNumber();
      } else if (playerOddCount > playerEvenCount) {
        fingers = Utils.getRandomEvenNumber();
      } else if (playerEvenCount == playerOddCount) {
        fingers = Utils.getRandomNumberRange(0, 5);
      }
    } else if (choice == Choice.ODD) {
      // If the player chose odd: If the number of odd fingers played by the player is greater than
      // the number of even let the AI play an even number. If the number of even fingers played by
      // the player is greater than the number of odd let the AI play an odd number. If the number
      // of odd fingers played by the player is equal to the number of even let the AI play a random
      // number.
      if (playerEvenCount > playerOddCount) {
        fingers = Utils.getRandomEvenNumber();
      } else if (playerOddCount > playerEvenCount) {
        fingers = Utils.getRandomOddNumber();
      } else if (playerEvenCount == playerOddCount) {
        fingers = Utils.getRandomNumberRange(0, 5);
      }
    }
    return fingers;
  }
}
