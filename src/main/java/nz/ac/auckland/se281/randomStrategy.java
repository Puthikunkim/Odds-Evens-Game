package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class randomStrategy implements Strategy {
  @Override
  public int getFingers(int playerEvenCount, int playerOddCount, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
