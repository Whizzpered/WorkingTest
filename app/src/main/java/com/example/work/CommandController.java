package com.example.work;

import com.example.work.command.Command;

import java.util.ArrayDeque;

public class CommandController {

    public static CommandController instance = new CommandController();
    ArrayDeque<Command> stack  = new ArrayDeque<>(16);
    TextModel textModel;

    public CommandController (){
    }

    public void setTextModel(TextModel textModel) {
        this.textModel = textModel;
    }

    public void addCommand(Command newCommand){
        stack.addLast(newCommand);
        newCommand.execute(textModel);
    }

    public void undo(){
        stack.pollLast().undo(textModel);
    }

    public static CommandController getInstance(){
        return instance;
    }

    public void addObserverToModel(Observer obs){
        textModel.addObserver(obs);
        obs.update(textModel);
    }

    public void removeObserverFromModel(Observer obs){
        textModel.removeObserver(obs);
    }
}
