package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface Ai {
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy);
}
