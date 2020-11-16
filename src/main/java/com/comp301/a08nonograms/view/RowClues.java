package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RowClues implements FXComponent {
  Controller controller;

  public RowClues(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane gridPane = new GridPane();
    for (int i = 0; i < controller.getClues().getHeight(); i++) {
      String clueTxt = "[";
      for (int j = 0; j < controller.getClues().getRowCluesLength(); j++) {
        clueTxt += (controller.getClues().getRowClues(i)[j] + " ");
      }
      clueTxt += "]";
      Text rowClue = new Text(0, 0, clueTxt);
      gridPane.add(rowClue, 0, i * 2);
      gridPane.add(new Text(0, 0, ""), 0, i * 2 + 1);
    }

    return gridPane;
  }
}
