package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Message implements FXComponent {
  private Controller controller;
  public Message(Controller controller){
    this.controller = controller;
  }

  @Override
  public Parent render() {
    if(controller.isSolved()){
      return new Pane();
    }
    return null;
  }
}
