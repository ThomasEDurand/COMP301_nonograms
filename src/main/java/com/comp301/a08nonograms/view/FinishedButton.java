package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FinishedButton implements FXComponent {
  Controller controller;

  public FinishedButton(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    GridPane layout = new GridPane();

    Button puzzleFinished = new Button();
    puzzleFinished.setText("finished");
    puzzleFinished.setOnAction(
        actionEvent -> {
          if (controller.isSolved()) {
            layout.add(new Text(0, 0, " Solved!"), 1, 0);
          } else {
            layout.add(new Text(0, 0, " Not Solved"), 1, 0);
          }
        });

    layout.add(puzzleFinished, 0, 0);

    return layout;
  }
}
