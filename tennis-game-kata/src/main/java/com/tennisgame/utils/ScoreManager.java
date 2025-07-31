package com.tennisgame.utils;

import com.tennisgame.models.Score;
import java.util.Map;

public class ScoreManager {
  /**
   * Update the score based on the point winner.
   * @param scores current scores of the players
   * @param winner winner of the point
   * @return true if the score has been updated, false if no further updates are possible
   */
  public static boolean updateScore(Map<Character, Score> scores, char winner) {
    char loser = getOpponent(winner);

    if (scores.get(winner) == Score.FORTY && scores.get(loser).getValue() < Score.FORTY.getValue()) {
      return false;
    } else if (Advantages.hasAdvantageA() || Advantages.hasAdvantageB()) {
      return Advantages.handleAdvantageCase(winner);
    } else if (scores.get(winner) == Score.FORTY && scores.get(loser) == Score.FORTY) {
      Advantages.setAdvantage(winner);
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
}
