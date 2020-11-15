package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.controller.ControllerImpl;
import com.comp301.a08nonograms.model.ModelImpl;
import com.comp301.a08nonograms.model.ModelObserver;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppLauncher extends Application{

  @Override
  public void start(Stage stage) {
    ModelImpl model = new ModelImpl(PuzzleLibrary.create());
    ControllerImpl controller = new ControllerImpl(model);
    
    stage.setTitle("Nonograms");
    stage.show();

  }
}
