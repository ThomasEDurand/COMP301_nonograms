package com.comp301.a08nonograms.model;

public class Puzzle {

  private CluesImpl clue;
  private BoardImpl board;
  private int puzzleIndex;

  public Puzzle(Clues clues, int puzzleIndex) {
    this.clue = (CluesImpl) clues;
    this.board = new BoardImpl(clues.getHeight(), clues.getWidth());
    this.puzzleIndex = puzzleIndex;
  }

  public int getPuzzleIndex() {
    return puzzleIndex;
  }

  public CluesImpl getClue() {
    return clue;
  }

  public BoardImpl getBoard() {
    return board;
  }
}



