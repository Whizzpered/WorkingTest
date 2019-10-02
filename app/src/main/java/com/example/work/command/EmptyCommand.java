package com.example.work.command;

import com.example.work.TextModel;

public class EmptyCommand implements Command {
    @Override
    public void setTextModel(TextModel target) {

    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
