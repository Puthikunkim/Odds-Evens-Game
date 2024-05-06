package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Ai interface to be implemented by the different diffculty levels of the AI. */
public interface Ai {
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy);
}
