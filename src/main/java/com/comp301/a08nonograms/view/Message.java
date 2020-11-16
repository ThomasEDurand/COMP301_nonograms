package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Message implements FXComponent {
  private Controller controller;
  public Message(Controller controller){
    this.controller = controller;
  }

  @Override
  public Parent render() {
    StackPane returnPane = new StackPane();
    if(controller.isSolved()){
      return null;
    }
    return null;
  }
}
