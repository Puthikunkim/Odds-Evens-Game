package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** AiFactory class to create an AI based on the difficulty. */
public class AiFactory {

  /**
   * Method to create an AI based on the difficulty.
   *
   * @param difficulty difficulty is the difficulty of the AI.
   * @return the AI created.
   */
  public static Ai createAi(Difficulty difficulty) {

    // Switch statement to determine the difficulty of the AI
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
      default: // Default case if the difficulty is not valid
        break;
    }
    return null; // Return null if the difficulty is not valid
  }
}
