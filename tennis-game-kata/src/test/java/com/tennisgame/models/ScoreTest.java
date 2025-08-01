package com.tennisgame.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

  @Test
  void testGetValue() {
    assertEquals(0, Score.LOVE.getValue(), "LOVE should have a value of 0");
    assertEquals(15, Score.FIFTEEN.getValue(), "FIFTEEN should have a value of 15");
    assertEquals(30, Score.THIRTY.getValue(), "THIRTY should have a value of 30");
    assertEquals(40, Score.FORTY.getValue(), "FORTY should have a value of 40");
  }

  @Test
  void testGetNext() {
    assertEquals(Score.FIFTEEN, Score.LOVE.getNext(), "Next score after LOVE should be FIFTEEN");
    assertEquals(Score.THIRTY, Score.FIFTEEN.getNext(), "Next score after FIFTEEN should be THIRTY");
    assertEquals(Score.FORTY, Score.THIRTY.getNext(), "Next score after THIRTY should be FORTY");
    assertEquals(Score.LOVE, Score.FORTY.getNext(), "Next score after FORTY should loop back to LOVE");
  }
}
