package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Order {
  private int playerEvenCount;
  private int playerOddCount;
  private Choice choice;
  private Strategy strategy;

  public Order(int playerEvenCount, int playerOddCount, Choice choice, Strategy strategy) {
    this.playerEvenCount = playerEvenCount;
    this.playerOddCount = playerOddCount;
    this.choice = choice;
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int fingersProcess() {
    return strategy.getFingers(playerEvenCount, playerOddCount, choice);
  }
}
