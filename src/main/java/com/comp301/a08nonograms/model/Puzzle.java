package com.comp301.a08nonograms.model;

public class Puzzle {

  private CluesImpl clue;
  private BoardImpl board;
  private int puzzleIndex;

  public Puzzle(Clues clues) {
    this.clue = (CluesImpl) clues;
    this.board = new BoardImpl(clues.getColCluesLength(), clues.getColCluesLength());
    this.puzzleIndex = 0; // TODO: Get index in list of puzzles
  }

  public int getPuzzleIndex() {
    return puzzleIndex;
  }

  public void setPuzzleIndex(int index) {
    puzzleIndex = index;
  }

  public CluesImpl getClue() {
    return clue;
  }

  public BoardImpl getBoard() {
    return board;
  }


}



