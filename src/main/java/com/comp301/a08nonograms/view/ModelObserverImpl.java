package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelImpl;
import com.comp301.a08nonograms.model.ModelObserver;

public class ModelObserverImpl implements ModelObserver {

  ModelImpl model;

  public ModelObserverImpl() {
    model = new ModelImpl(PuzzleLibrary.create());
  }

  @Override
  public void update(Model model) {

  }
}
