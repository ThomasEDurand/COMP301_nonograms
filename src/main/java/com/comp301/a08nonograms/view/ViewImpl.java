package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ViewImpl implements FXComponent {
  Controller controller;

  public ViewImpl(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    BorderPane layout = new BorderPane();
    // Buttons
    Controls controls = new Controls(controller);
    layout.setRight(controls.render());

    // Clues
    RowClues rowClues = new RowClues(controller);
    layout.setLeft(rowClues.render());

    ColClues colClues = new ColClues(controller);
    layout.setTop(colClues.render());

    FinishedButton finishedButton = new FinishedButton(controller);
    layout.setBottom(finishedButton.render());

    // Nanogram

    Board board = new Board(controller);
    layout.setCenter(board.render());

    return layout;
  }
}
