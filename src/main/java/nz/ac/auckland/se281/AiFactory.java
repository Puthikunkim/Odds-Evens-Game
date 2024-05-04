package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
      default:
        break;
    }
    return null;
  }
}
