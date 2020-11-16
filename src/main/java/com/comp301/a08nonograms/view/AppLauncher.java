package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.controller.ControllerImpl;
import com.comp301.a08nonograms.model.ModelImpl;
import com.comp301.a08nonograms.model.ModelObserver;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    ModelImpl model = new ModelImpl(PuzzleLibrary.create());
    ControllerImpl controller = new ControllerImpl(model);
    stage.setTitle("NONOGRAMS");
    ViewImpl view = new ViewImpl(controller);

    
    Scene scene = new Scene(view.render(), 720, 600);
    stage.setScene(scene);


    stage.show();

  }
}
