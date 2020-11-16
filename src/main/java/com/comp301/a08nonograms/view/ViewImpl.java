package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ViewImpl implements FXComponent{
  Controller controller;

  public ViewImpl(Controller controller){
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    Controls controls = new Controls(controller);
    layout.getChildren().add(controls.render());

    // TODO: SCENE


    // Nanogram

    Board board = new Board(controller);
    layout.getChildren().add(board.render());

    return layout;
  }
}
