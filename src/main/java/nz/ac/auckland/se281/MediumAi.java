package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements Ai {

  @Override
  public int getFingers(int roundNumber, int playerEvenCount, int playerOddCount, Choice choice) {
    int fingers = 0;
    if (roundNumber <= 3) {
      fingers = Utils.getRandomNumberRange(0, 5);
    } else {
      if (choice == Choice.EVEN) {
        if (playerEvenCount > playerOddCount) {
          fingers = Utils.getRandomOddNumber();
        } else if (playerOddCount > playerEvenCount) {
          fingers = Utils.getRandomEvenNumber();
        } else if (playerEvenCount == playerOddCount) {
          fingers = Utils.getRandomNumberRange(0, 5);
        }
      } else if (choice == Choice.ODD) {
        if (playerEvenCount > playerOddCount) {
          fingers = Utils.getRandomEvenNumber();
        } else if (playerOddCount > playerEvenCount) {
          fingers = Utils.getRandomOddNumber();
        } else if (playerEvenCount == playerOddCount) {
          fingers = Utils.getRandomNumberRange(0, 5);
        }
      }
    }
    String print_info_hand =
        MessageCli.PRINT_INFO_HAND.getMessage("HAL-9000", String.valueOf(fingers));
    System.out.println(print_info_hand);
    return fingers;
  }
}
