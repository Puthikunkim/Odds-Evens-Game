package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** HardAi class to create a Hard AI. */
public class HardAi implements Ai {

  // Method to get the number of fingers the AI will play
  @Override
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy) {

    int fingers = 0;
    // If the round number is less than or equal to 3, the AI will use the Random strategy
    if (roundNumber <= 3) {
      Order order = new Order(playerEvenCount, playerOddCount, choice, new RandomStrategy());
      fingers = order.fingersProcess();
    } else { // If the round number is greater than 3, the AI will switched strategy based on if it
      // won or lost the previous round
      if (strategy.equals("Random")) {
        Order order = new Order(playerEvenCount, playerOddCount, choice, new RandomStrategy());
        fingers = order.fingersProcess();
      } else if (strategy.equals("Top")) {
        Order order = new Order(playerEvenCount, playerOddCount, choice, new TopStrategy());
        fingers = order.fingersProcess();
      }
    }

    // Print the number of fingers the AI played
    String infoHandMessage =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(infoHandMessage);
    return fingers;
  }
}
