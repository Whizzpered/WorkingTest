package com.example.work.command;

import com.example.work.TextModel;

public class SwitchBoldCommand implements Command {

    TextModel textModel;

    public void setTextModel(TextModel textModel) {
        this.textModel = textModel;
    }

    @Override
    public void execute() {
        textModel.setBold();
    }

    @Override
    public void undo() {
        textModel.setBold();
    }
}
