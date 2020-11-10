package com.comp301.a08nonograms.model;

public class CluesImpl implements Clues{
  private int[][] rowClues;
  private int[][] colClues;
  private int totalShaded;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    this.rowClues = colClues;
    this.colClues = colClues;

    for (int[] rowClue : rowClues) {
      for (int i : rowClue) {
        totalShaded += i;
      }
    }

  }

  @Override
  public int getWidth() {
    return rowClues.length;
  }

  @Override
  public int getHeight() {
    return colClues.length;
  }

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
    return colClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }

  public int getTotalShaded(){return totalShaded;}

}
