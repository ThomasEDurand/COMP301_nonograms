package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  ArrayList<Puzzle> puzzleList;
  ArrayList<ModelObserver> modelObservers;
  public Puzzle activePuzzle;

  public ModelImpl(List<Clues> clues) {
    puzzleList = new ArrayList<>();
    modelObservers = new ArrayList<>();
    for (int i = 0; i < clues.size(); i++) {
      puzzleList.add(new Puzzle(clues.get(i), i)); // create an list of puzzles with indicies
    }
    activePuzzle = puzzleList.get(0); // default set active puzzle as first puzzle
  }

  @Override
  public int getPuzzleCount() {
    return puzzleList.size();
  }

  @Override
  public int getPuzzleIndex() {
    return activePuzzle.getPuzzleIndex();
  }

  @Override
  public void setPuzzleIndex(int index) {
    activePuzzle = puzzleList.get(index);
    notifyObs();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    modelObservers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    modelObservers.remove(observer);
  }

  @Override
  public boolean isSolved() {

    // quick check to see if number shaded on board = number shaded from clues
    // should fix edge case in for loops checking a cluster on that ends with the board
//    if (activePuzzle.getBoard().getNumShaded() != activePuzzle.getClue().getTotalShaded()) {
//      return false;
//    }

    // rows
    for (int i = 0; i < activePuzzle.getClue().getHeight(); i++) {
      int cluesSum = 0;
      for (int j = 0; j < activePuzzle.getClue().getRowClues(i).length; j++) {
        cluesSum += activePuzzle.getClue().getRowClues(i)[j];
      }

      int rowCount = 0;
      for (int j = 0; j < activePuzzle.getBoard().board[i].length; j++) {
        if (isShaded(i, j)) {
          rowCount++;
        }
      }

      if (rowCount != cluesSum) {
        return false;
      }
    }

    // cols
    for (int i = 0; i < activePuzzle.getClue().getWidth(); i++) {
      int cluesSum = 0;
      for (int j = 0; j < activePuzzle.getClue().getColClues(i).length; j++) {
        cluesSum += activePuzzle.getClue().getColClues(i)[j];
      }

      int rowCount = 0;
      for (int j = 0; j < activePuzzle.getClue().getHeight(); j++) {
        if (isShaded(j, i)) {
          rowCount++;
        }
      }

      if (rowCount != cluesSum) {
        return false;
      }
    }

    return true;
  } // Needs work

  @Override
  public boolean isShaded(int row, int col) {
    return activePuzzle.getBoard().isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return activePuzzle.getBoard().isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return activePuzzle.getBoard().isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    activePuzzle.getBoard().toggleCellShaded(row, col);
    notifyObs();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    activePuzzle.getBoard().toggleCellEliminated(row, col);
    notifyObs();
  }

  @Override
  public void clear() {
    activePuzzle.getBoard().clear();
    notifyObs();
  }

  @Override
  public int getWidth() {
    return activePuzzle.getClue().getWidth();
  }

  @Override
  public int getHeight() {
    return activePuzzle.getClue().getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return activePuzzle.getClue().getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return activePuzzle.getClue().getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return activePuzzle.getClue().getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return activePuzzle.getClue().getColCluesLength();
  }

  public void notifyObs() {

    for (ModelObserver modelObserver : modelObservers) {
      modelObserver.update(this);
    }
  }


}
