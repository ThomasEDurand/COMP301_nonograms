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

        // required for lambda
        int finalI = i;
        int finalJ = j;

        Button gridButton = new Button();
        if (controller.isShaded(finalI, finalJ)) {
          gridButton.setStyle("-fx-background-color: black");
        } else if (controller.isEliminated(finalI, finalJ)) {
          gridButton.setStyle("-fx-background-color: red");
        }

        gridButton.setOnMousePressed(
            (MouseEvent event) -> {
              if (event.getButton() == MouseButton.PRIMARY) {
                controller.toggleShaded(finalI, finalJ);
              } else if (event.getButton() == MouseButton.SECONDARY) {
                controller.toggleEliminated(finalI, finalJ);
              } // do not want functionality for buttons besides m1 and m2
            });
        gridButton.setMaxHeight(32);
        gridButton.setMinHeight(32);
        gridButton.setMaxWidth(32);
        gridButton.setMinWidth(32);
        gridPane.add(gridButton, finalJ, finalI);
      }
    }

    return gridPane;
  }
}
