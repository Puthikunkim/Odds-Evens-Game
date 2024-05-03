package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
    }
    return null;
  }
}
