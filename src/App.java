import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
  /**
   * Enum representing possible scores in a tennis game.
   */
  private enum Score {
    LOVE(0), FIFTEEN(15), THIRTY(30), FORTY(40);

    private final int value;

    Score(int value) {
      this.value = value;
    }

    /**
     * Get numerical value of the score.
     * @return the numerical value
     */
    private int getValue() {
      return value;
    }

    /**
     * Get next score in the sequence.
     * @return the next score
     */
    private Score getNext() {
      List<Score> scores = List.of(Score.values());
      int nextIndex = (this.ordinal() + 1) % scores.size();
      return scores.get(nextIndex);
    }
  }

  /**
   * Utility class for managing advantages in a tennis game.
   */
  private static class Advantages {
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
  }

  /**
   * Compute the score for a tennis game based on the input string.
   * @param input a string representing the sequence of point winners
   */
  public static void computeScore(String input) {
    Map<Character, Score> scores = new HashMap<>();
    scores.put('A', Score.LOVE);
    scores.put('B', Score.LOVE);

    for (char c : input.toCharArray()) {
      if ("AB".indexOf(c) == -1) {
        continue;
      }
      
      char pointWinner = (char) c;

      if (!updateScore(scores, pointWinner)) {
        announceWinner(pointWinner);
        break;
      }

      printScore(scores, pointWinner);
    };
  }

  /**
   * Update the score based on the point winner.
   * @param scores current scores of the players
   * @param winner winner of the point
   * @return true if the score has been updated, false if no further updates are possible
   */
  private static boolean updateScore(Map<Character, Score> scores, char winner) {
    char loser = getOpponent(winner);

    if (scores.get(winner) == Score.FORTY && scores.get(loser).getValue() < Score.FORTY.getValue()) {
      return false;
    } else if (Advantages.hasAdvantageA() || Advantages.hasAdvantageB()) {
      return handleAdvantageCase(winner);
    } else if (scores.get(winner) == Score.FORTY && scores.get(loser) == Score.FORTY) {
      setAdvantage(winner);
      return true;
    } else {
      scores.put(winner, scores.get(winner).getNext());
      return true;
    }
  }

  /**
   * Get the opponent of the specified player.
   * @param player player for whom to find the opponent
   * @return the opponent of the specified player
   */
  private static char getOpponent(char player) {
    return player == 'A' ? 'B' : 'A';
  }

  /**
   * Handle the advantage case in the game.
   * @param winner winner of the point
   * @return true if the score changed following an advantage, false otherwise
   */
  private static boolean handleAdvantageCase(char winner) {
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
  private static void setAdvantage(char winner) {
    if (winner == 'A') {
      Advantages.setAdvantageA(true);
    } else {
      Advantages.setAdvantageB(true);
    }
  }

  /**
   * Reset the advantages for both players.
   */
  private static void resetAdvantages() {
    Advantages.setAdvantageA(false);
    Advantages.setAdvantageB(false);
  }

  /**
   * Announce the winner of the game.
   * @param winner the winner of the game
   */
  private static void announceWinner(char winner) {
    System.out.printf("Player %s wins the game!%n", winner);
  }

  /**
   * Prints the current score of the game.
   * @param scores the current scores of the players
   * @param winner the winner of the last point
   */
  private static void printScore(Map<Character, Score> scores, char winner) {
    if (Advantages.hasAdvantageA() || Advantages.hasAdvantageB()) {
      System.out.printf("Advantage Player %s.%n", winner);
    } else if (scores.get('A') == Score.FORTY && scores.get('B') == Score.FORTY) {
      System.out.println("DEUCE");
    } else {
      System.out.printf("Player A : %d / Player B : %d%n", scores.get('A').getValue(), scores.get('B').getValue());
    }
  }

  /**
   * Main method to run the tennis score computation.
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    String input = "ABABAA";
    computeScore(input);
  }
}
