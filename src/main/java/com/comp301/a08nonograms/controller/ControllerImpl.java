package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelImpl;
import java.util.concurrent.ThreadLocalRandom;

public class ControllerImpl implements Controller {

  ModelImpl model;

  public ControllerImpl(ModelImpl model) {
    this.model = model;
  }

  @Override
  public Clues getClues() {
    return model.activePuzzle.getClue();
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    if (getPuzzleIndex() == getPuzzleCount() - 1) { // if index is the last one, go to zero
      model.setPuzzleIndex(0);
    } else {
      model.setPuzzleIndex(getPuzzleIndex() + 1); // otherwise go up one
    }
  }

  @Override
  public void prevPuzzle() {
    if (getPuzzleIndex() == 0) {
      model.setPuzzleIndex(getPuzzleCount() - 1);
    } else {
      model.setPuzzleIndex(getPuzzleIndex() - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int randomNum = ThreadLocalRandom.current().nextInt(0, getPuzzleCount());
    model.setPuzzleIndex(randomNum);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
