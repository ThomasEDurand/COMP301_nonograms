package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Board implements FXComponent {
  private Controller controller;
  private int height;
  private int width;

  public Board(Controller controller) {
    this.controller = controller;
    this.height = controller.getClues().getHeight();
    this.width = controller.getClues().getWidth();
  }

  @Override
  public Parent render() {
    GridPane gridPane = new GridPane();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        Button gridButton = new Button();
        // gridButton.setStyle("-fx-background-color: white"); // initialize to white

        // required for lambda
        int finalI = i;
        int finalJ = j;
        gridButton.setOnMousePressed(
            (MouseEvent event) -> {
              if (event.getButton() == MouseButton.PRIMARY) {
                controller.toggleShaded(finalI, finalJ);
              } else if (event.getButton() == MouseButton.SECONDARY) {
                controller.isEliminated(finalI, finalJ);
              } // do not want functionality for buttons besides m1 and m2
            });
        gridButton.setMaxHeight(25);
        gridButton.setMinHeight(25);
        gridButton.setMaxWidth(25);
        gridButton.setMinWidth(25);
        gridPane.add(gridButton, finalJ, finalI);
      }
    }

    return gridPane;
  }
}
