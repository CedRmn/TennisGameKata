package com.tennisgame.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class AdvantagesTest {

  @BeforeEach
  void init() {
    Advantages.resetAdvantages();
  }

  @Test
  void testHasAdvantageA() {
    assertFalse(Advantages.hasAdvantageA(), "Player A should not have advantage initially");

    Advantages.setAdvantageA(true);
    assertTrue(Advantages.hasAdvantageA(), "Player A should have advantage after setting it");
  }

  @Test
  void testHasAdvantageB() {
    assertFalse(Advantages.hasAdvantageB(), "Player B should not have advantage initially");

    Advantages.setAdvantageB(true);
    assertTrue(Advantages.hasAdvantageB(), "Player B should have advantage after setting it");
  }

  @Test
  void testSetAdvantageA() {
    Advantages.setAdvantageA(true);
    assertTrue(Advantages.hasAdvantageA(), "Player A should have advantage after setting it");

    Advantages.setAdvantageA(false);
    assertFalse(Advantages.hasAdvantageA(), "Player A should not have advantage after resetting it");
  }

  @Test
  void testSetAdvantageB() {
    Advantages.setAdvantageB(true);
    assertTrue(Advantages.hasAdvantageB(), "Player B should have advantage after setting it");

    Advantages.setAdvantageB(false);
    assertFalse(Advantages.hasAdvantageB(), "Player B should not have advantage after resetting it");
  }

  @Test
  void testHandleAdvantageCase() {
    Advantages.setAdvantageB(true);
    assertTrue(Advantages.handleAdvantageCase('A'), "Advantage should be reset if the other player scores");

    assertFalse(Advantages.hasAdvantageA(), "Player A should not have advantage after handling advantage case");
    assertFalse(Advantages.hasAdvantageB(), "Player B should not have advantage after handling advantage case");

    Advantages.setAdvantageA(true);
    assertFalse(Advantages.handleAdvantageCase('A'), "Player A should win if they have advantage and score");
  }

  @Test
  void testSetAdvantage() {
    Advantages.setAdvantage('A');
    assertTrue(Advantages.hasAdvantageA(), "Player A should have advantage after setting it");
    assertFalse(Advantages.hasAdvantageB(), "Player B should not have advantage after setting advantage to A");

    Advantages.resetAdvantages();
    Advantages.setAdvantage('B');
    assertFalse(Advantages.hasAdvantageA(), "Player A should not have advantage after setting advantage to B");
    assertTrue(Advantages.hasAdvantageB(), "Player B should have advantage after setting it");
  }

  @Test
  void testResetAdvantages() {
    Advantages.setAdvantageA(true);
    Advantages.setAdvantageB(true);
    Advantages.resetAdvantages();

    assertFalse(Advantages.hasAdvantageA(), "Player A should not have advantage after resetting");
    assertFalse(Advantages.hasAdvantageB(), "Player B should not have advantage after resetting");
  }
}
