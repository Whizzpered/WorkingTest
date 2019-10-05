package com.example.work;

public class ObserverController {

    TextModel model;

    public ObserverController(TextModel model){
        this.model = model;
    }

    public void addObserverToModel(Observer obs) {
        model.addObserver(obs);
        obs.update(model);
    }

    public void removeObserverFromModel(Observer obs) {
        model.removeObserver(obs);
    }
}
