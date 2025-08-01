package com.tennisgame;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.tennisgame.models.Score;
import com.tennisgame.utils.ScoreManager;

class TennisGameTest {

  @Test
  void testComputeScore() {
    // Arrange
    MockedStatic<ScoreManager> mockedScoreManager = Mockito.mockStatic(ScoreManager.class);

    Map<Character, Score> scores = new HashMap<>();
    scores.put('A', Score.LOVE);
    scores.put('B', Score.LOVE);

    when(ScoreManager.updateScore(any(Map.class), anyChar())).thenReturn(true);

    // Act
    TennisGame.computeScore("ABABAA");

    // Assert
    mockedScoreManager.verify(() -> ScoreManager.updateScore(any(Map.class), anyChar()), times(6));
  }
}
