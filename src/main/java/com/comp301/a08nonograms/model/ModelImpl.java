package com.comp301.a08nonograms.model;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.sun.scenario.effect.Blend.Mode;
import java.util.List;
import java.util.Random;

public class ModelImpl implements Model {
  BoardImpl board;
  List<Clues> cluesList;
  List<ModelObserver> modelObservers;

  public Puzzle activePuzzle;

  public ModelImpl(List<Clues> clues) {
      this.cluesList = clues;
      activePuzzle = new Puzzle(clues.get(0)); // default set active puzzle as first puzzle
  }

  @Override
  public int getPuzzleCount() {
    return cluesList.size();
  }

  @Override
  public int getPuzzleIndex() {
    return activePuzzle.getPuzzleIndex();
  }

  @Override
  public void setPuzzleIndex(int index) {
    activePuzzle.setPuzzleIndex(index);
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

    // TODO: Implement Solved method

    // quick check to see if number shaded on board = number shaded from clues
    // should fix edge case in for loops checking a cluster on that ends with the board
    if(activePuzzle.getBoard().getNumShaded() != activePuzzle.getClue().getTotalShaded()){
      return false;
    }

    // Check Row Clues
    for(int i = 0; i < getHeight(); i++){ // for every row

      int clusterSize = 0;
      int clusterNumber = 0;
      boolean inCluster = false;
      for(int j = 0; j < getWidth(); j++){ // for each element of a row
        if(isSpace(i,j)){
          return false; // Should be no spaces, only shaded and eliminated
        } else if (isShaded(i, j)){
          inCluster = true;
          if(clusterSize > activePuzzle.getClue().getRowClues(i)[clusterNumber]){
            return false;
          }
          clusterSize++;
        } else { // eliminated, end of cluster
          if(inCluster){
            if(clusterSize != activePuzzle.getClue().getRowClues(i)[clusterNumber]){
              return false;
            } else {
              inCluster = false;
              clusterSize = 0;//
              clusterNumber++;
            }
          }
        }
      }
    }

    // Check Col Clues

    for(int i = 0; i < getWidth(); i++){ // for every column

      int clusterSize = 0;
      int clusterNumber = 0;
      boolean inCluster = false;
      for(int j = 0; j < getHeight(); j++){ // for each element of a row
        if(isSpace(j,i)){
          return false; // Should be no spaces, only shaded and eliminated
        } else if (isShaded(j, i)){
          inCluster = true;
          if(clusterSize > activePuzzle.getClue().getColClues(i)[clusterNumber]){
            return false;
          }
          clusterSize++;
        } else { // eliminated, end of cluster
          if(inCluster){
            if(clusterSize != activePuzzle.getClue().getColClues(i)[clusterNumber]){
              return false;
            } else {
              inCluster = false;
              clusterSize = 0;//
              clusterNumber++;
            }
          }
        }
      }
    }
    
    return true;
  }

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
    notify();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    activePuzzle.getBoard().toggleCellEliminated(row, col);
    notify();
  }

  @Override
  public void clear() {
    activePuzzle.getBoard().clear();
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


}
