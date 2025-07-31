package com.tennisgame;

import java.util.HashMap;
import java.util.Map;
import com.tennisgame.models.Score;
import com.tennisgame.utils.Advantages;
import com.tennisgame.utils.ScoreManager;

public class TennisGame {
  /**
   * Main method to run the tennis score computation.
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    String input = "ABABAA";
    computeScore(input);
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

      if (!ScoreManager.updateScore(scores, pointWinner)) {
        announceWinner(pointWinner);
        break;
      }

      printScore(scores, pointWinner);
    }
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
}
