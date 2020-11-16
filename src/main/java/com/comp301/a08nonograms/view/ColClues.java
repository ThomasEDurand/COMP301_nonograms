package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ColClues implements FXComponent{
  Controller controller;

  public ColClues(Controller controller){this.controller = controller;}

  @Override
  public Parent render() {
    GridPane gridPane = new GridPane();
    gridPane.add(new Text(0,0, "       "), 0, 0); // Blank Square for top left corner
    for(int i = 0; i < controller.getClues().getWidth(); i++){
      String clueTxt = "[";
      for(int j = 0; j < controller.getClues().getColCluesLength(); j++){
        clueTxt += (controller.getClues().getColClues(i)[j] + " ");
      }
      clueTxt += "]";
      Text rowClue = new Text(0,0, clueTxt);
      gridPane.add(rowClue, i + 1, 0);
    }

    return gridPane;
  }
}
