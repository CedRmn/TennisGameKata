package com.tennisgame.models;

import java.util.List;

/**
 * Enum representing possible scores in a tennis game.
 */
public enum Score {
  LOVE(0), FIFTEEN(15), THIRTY(30), FORTY(40);

  private final int value;

  Score(int value) {
    this.value = value;
  }

  /**
   * Get numerical value of the score.
   * @return the numerical value
   */
  public int getValue() {
    return value;
  }

  /**
   * Get next score in the sequence.
   * @return the next score
   */
  public Score getNext() {
    List<Score> scores = List.of(Score.values());
    int nextIndex = (this.ordinal() + 1) % scores.size();
    return scores.get(nextIndex);
  }
}