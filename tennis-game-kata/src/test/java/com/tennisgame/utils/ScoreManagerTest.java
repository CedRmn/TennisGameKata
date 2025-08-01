package com.tennisgame.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import com.tennisgame.models.Score;

public class ScoreManagerTest {
  private Map<Character, Score> scores;

  @BeforeEach
  void init() {
    scores = new HashMap<>();
  }

  @AfterEach
  void teardown() {
    Advantages.resetAdvantages();
  }

  @Test
  void testUpdateScoreWithWinnerAtForty() {
    // Arrange
    scores.put('A', Score.FORTY);
    scores.put('B', Score.THIRTY);

    // Act && Assert
    assertFalse(ScoreManager.updateScore(scores, 'A'), "Game should end if player A reaches FORTY and wins");
  }

  @Test
  void testUpdateScoreWithAdvantage() {
    // Arrange
    Advantages.setAdvantageA(true);
    scores.put('A', Score.FORTY);
    scores.put('B', Score.FORTY);

    // Act && Assert
    assertTrue(ScoreManager.updateScore(scores, 'B'), "Advantage should be handled correctly");
  }

  @Test
  void testUpdateScoreWithDeuce() {
    // Arrange
    scores.put('A', Score.FORTY);
    scores.put('B', Score.FORTY);

    // Act && Assert
    assertTrue(ScoreManager.updateScore(scores, 'A'), "Advantage should be set for player A at deuce");
    assertTrue(Advantages.hasAdvantageA(), "Player A should have advantage after scoring at deuce");
  }

  @Test
  void testUpdateScoreNormalCase() {
    // Arrange
    scores.put('A', Score.LOVE);
    scores.put('B', Score.LOVE);

    // Act && Assert
    assertTrue(ScoreManager.updateScore(scores, 'A'), "Score should be updated for player A");
    assertEquals(Score.FIFTEEN, scores.get('A'), "Player A score should be FIFTEEN");
  }
}
