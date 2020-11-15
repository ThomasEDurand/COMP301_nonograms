package com.comp301.a08nonograms.model;

public class BoardImpl implements Board {

  public enum selection {SPACE, SHADED, ELIMINATED}
  public selection[][] board;

  public BoardImpl(int rows, int columns) {
    board = new selection[rows][columns];
    // Initialize all spaces in board array to SPACE
    clear();
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
      throw new RuntimeException();
    }
    return (board[row][col] == selection.SHADED);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
      throw new RuntimeException();
    }
    return (board[row][col] == selection.ELIMINATED);
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
      throw new RuntimeException();
    }
    return (board[row][col] == selection.SPACE);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
      throw new RuntimeException();
    }
    if (board[row][col] == selection.SHADED) {
      board[row][col] = selection.SPACE;
    } else if (board[row][col] == selection.SPACE) {
      board[row][col] = selection.SHADED;
    } else { // if eliminated
      board[row][col] = selection.SHADED;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
      throw new RuntimeException();
    }
    if (board[row][col] == selection.ELIMINATED) {
      board[row][col] = selection.SPACE;
    } else if (board[row][col] == selection.SPACE) {
      board[row][col] = selection.ELIMINATED;
    } else { // if Shaded
      board[row][col] = selection.ELIMINATED;
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = selection.SPACE;
      }
    }
  }

}
