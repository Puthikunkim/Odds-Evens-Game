package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements Ai {

  @Override
  public int getFingers(int roundNumber, int playerEvenCount, int playerOddCount, Choice choice) {
    int fingers = 0;
    if (roundNumber <= 3) {
      fingers = Utils.getRandomNumberRange(0, 5);
    } else {

    }
    return fingers;
  }
}
