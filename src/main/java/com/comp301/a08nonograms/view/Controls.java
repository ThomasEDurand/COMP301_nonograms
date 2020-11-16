package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Controls implements FXComponent {
  private final Controller controller;

  public Controls(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane layout = new GridPane();
    layout.setPadding(new Insets(15, 15, 15, 15));

    Button previousPuzzle = new Button();
    previousPuzzle.setText("previous");
    previousPuzzle.setOnAction(
        actionEvent -> {
          controller.prevPuzzle();
        });

    Button randomPuzzle = new Button();
    randomPuzzle.setText("random");
    randomPuzzle.setOnAction(
        actionEvent -> {
          controller.randPuzzle();
        });

    Button nextPuzzle = new Button();
    nextPuzzle.setText("next");
    nextPuzzle.setOnAction(actionEvent -> controller.nextPuzzle());

    Button puzzleFinished = new Button();
    puzzleFinished.setText("finished");
    puzzleFinished.setOnAction(
        actionEvent -> {
          if (controller.isSolved()) {
            System.out.println("SOLVED!");
          } else {
            System.out.println("Not solved");
          }
        });

    Text puzzleNo =
        new Text(
            0, 0, "Puzzle " + controller.getPuzzleIndex() + "/ " + controller.getPuzzleCount());
    layout.add(puzzleNo, 0, 0);
    layout.add(previousPuzzle, 0, 1);
    layout.add(randomPuzzle, 0, 2);
    layout.add(nextPuzzle, 0, 3);
    layout.add(puzzleFinished, 0, 4);

    return layout;
  }
}
