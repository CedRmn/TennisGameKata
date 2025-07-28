# Tennis Game Kata

A simple Java application to compute and display the score of a tennis game based on a sequence of point winners.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Usage](#usage)
- [Code Structure](#code-structure)

## Description

This application simulates the scoring system of a tennis game. It takes a string input representing the sequence of point winners and computes the score after each point, handling special cases such as "deuce" and "advantage."

## Features

- Computes tennis scores based on input sequences.
- Handles special scoring rules including "deuce" and "advantage."
- Validates input to ensure only valid characters are processed.
- Provides clear output of the game state after each point.

## Usage

To use this application, you need to have Java installed on your system. You can run the application from the command line as follows:

1. Compile the Java code:
   ```sh
   javac App.java
   ```

2. Run the compiled program:
   ```sh
   java App
   ```

By default, the application uses the input sequence "ABABAA". You can modify the main method in the App class to use a different input sequence.

## Code Structure

- `App`: The main class containing the application logic.
  - `Score`: An enum representing possible scores in a tennis game.
  - `Advantages`: A utility class for managing advantages in the game.
  - `computeScore`: Computes the score for a given input sequence.
  - `updateScore`: Updates the score based on the winner of a point.
  - `getOpponent`: Determines the opponent of a given player.
  - `handleAdvantageCase`: Handles the advantage logic in the game.
  - `setAdvantage`: Sets the advantage for a player.
  - `resetAdvantage`: Resets the advantages for both players.
  - `announceWinner`: Announces the winner of the game.
  - `printScore`: Prints the current score of the game.
