package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Controls implements FXComponent{
  private final Controller controller;

  public Controls(Controller controller){this.controller = controller;}

  @Override
  public Parent render() {
    StackPane layout = new StackPane();
    layout.setPadding(new Insets(15, 15, 15, 15));

    Button nextPuzzle = new Button();
    nextPuzzle.setText(">");
    nextPuzzle.setOnAction(
        actionEvent -> controller.nextPuzzle()
    );
    layout.getChildren().add(nextPuzzle);


    return layout;

  }
}
