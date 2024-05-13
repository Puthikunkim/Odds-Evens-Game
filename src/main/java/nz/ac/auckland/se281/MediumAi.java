package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** MediumAi class to implement the Medium AI. */
public class MediumAi implements Ai {

  // Method to get the number of fingers the AI will play
  @Override
  public int getFingers(
      int roundNumber, int playerEvenCount, int playerOddCount, Choice choice, String strategy) {

    int fingers;
    Order order = new Order(playerEvenCount, playerOddCount, choice, new RandomStrategy());
    // If the round number is less than or equal to 3, the AI will use the Random strategy
    if (roundNumber <= 3) {
      order.setStrategy(new RandomStrategy());
      fingers = order.fingersProcess();
    } else { // If the round number is greater than 3, the AI will use the Top strategy
      order.setStrategy(new TopStrategy());
      fingers = order.fingersProcess();
    }
    // Print the number of fingers the AI played
    String infoHandMessage =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(infoHandMessage);
    return fingers;
  }
}
