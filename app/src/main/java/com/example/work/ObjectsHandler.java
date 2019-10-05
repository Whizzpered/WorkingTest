package com.example.work;

public class ObjectsHandler {

    private TextModel textModel;
    private CommandController commandController;
    private ObserverController observerController;
    private CommandFactory commandFactory;

    public ObjectsHandler(){
        textModel = new TextModel();
        commandController = new CommandController(textModel);
        observerController = new ObserverController(textModel);
        commandFactory = new CommandFactory(commandController);
    }

    public TextModel getTextModel() {
        return textModel;
    }

    public CommandController getCommandController() {
        return commandController;
    }

    public ObserverController getObserverController() {
        return observerController;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }

}
