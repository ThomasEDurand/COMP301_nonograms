package com.comp301.a08nonograms.model;

public class CluesImpl implements Clues {

  private int[][] rowClues;
  private int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new NullPointerException();
    }
    this.rowClues = rowClues;
    this.colClues = colClues;
  }

  @Override
  public int getWidth() {
    return colClues.length;
  } // num of cols is the width

  @Override
  public int getHeight() {
    return rowClues.length;
  } // num of rows is the length

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    return colClues[index];
  }

  @Override
  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }
}
