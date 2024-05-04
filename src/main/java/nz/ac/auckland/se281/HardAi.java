package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAi implements Ai {

  @Override
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy) {
    int fingers = 0;
    if (roundNumber <= 3) {
      Order order = new Order(playerEvenCount, playerOddCount, choice, new randomStrategy());
      fingers = order.fingersProcess();
    } else {
      if (playerWinRound) {
        if (strategy.equals("Random")) {
          Order order = new Order(playerEvenCount, playerOddCount, choice, new topStrategy());
          fingers = order.fingersProcess();
        } else if (strategy.equals("Top")) {
          Order order = new Order(playerEvenCount, playerOddCount, choice, new randomStrategy());
          fingers = order.fingersProcess();
        }
      } else if (!playerWinRound) {
        if (strategy.equals("Random")) {
          Order order = new Order(playerEvenCount, playerOddCount, choice, new randomStrategy());
          fingers = order.fingersProcess();
        } else if (strategy.equals("Top")) {
          Order order = new Order(playerEvenCount, playerOddCount, choice, new topStrategy());
          fingers = order.fingersProcess();
        }
      }
    }
    String print_info_hand =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(print_info_hand);
    return fingers;
  }
}
