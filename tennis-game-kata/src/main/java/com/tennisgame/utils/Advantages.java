package com.tennisgame.utils;

/**
 * Utility class for managing advantages in a tennis game.
 */
public class Advantages {
  private static boolean advantageA = false;
  private static boolean advantageB = false;

  /**
   * Check if Player A has the advantage.
   * @return true if Player A has the advantage, false otherwise
   */
  public static boolean hasAdvantageA() {
    return advantageA;
  }

  /**
   * Check if Player B has the advantage.
   * @return true if Player B has the advantage, false otherwise
   */
  public static boolean hasAdvantageB() {
    return advantageB;
  }

  /**
   * Set the advantage for Player A.
   * @param advantageA true to set advantage for Player A, false otherwise
   */
  public static void setAdvantageA(boolean advantageA) {
    Advantages.advantageA = advantageA;
  }

  /**
   * Set the advantage for Player B.
   * @param advantageB true to set advantage for Player B, false otherwise
   */
  public static void setAdvantageB(boolean advantageB) {
    Advantages.advantageB = advantageB;
  }

  /**
   * Handle the advantage case in the game.
   * @param winner winner of the point
   * @return true if the score changed following an advantage, false otherwise
   */
  public static boolean handleAdvantageCase(char winner) {
    if ((winner == 'A' && Advantages.hasAdvantageB()) || (winner == 'B' && Advantages.hasAdvantageA())) {
      resetAdvantages();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Set the advantage for the specified player.
   * @param winner the player to set the advantage for
   */
  public static void setAdvantage(char winner) {
    if (winner == 'A') {
      Advantages.setAdvantageA(true);
    } else {
      Advantages.setAdvantageB(true);
    }
  }

  /**
   * Reset the advantages for both players.
   */
  public static void resetAdvantages() {
    Advantages.setAdvantageA(false);
    Advantages.setAdvantageB(false);
  }
}
