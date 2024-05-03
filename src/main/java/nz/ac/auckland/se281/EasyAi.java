package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAi implements Ai {

  @Override
  public int getFingers(
      int roundNumber,
      int playerEvenCount,
      int playerOddCount,
      Choice choice,
      boolean playerWinRound,
      String strategy) {
    Order order = new Order(playerEvenCount, playerOddCount, choice, new randomStrategy());
    int fingers = order.fingersProcess();
    String print_info_hand =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(print_info_hand);
    return fingers;
  }
}
