package com.example.work.command;

import com.example.work.TextModel;

public class IncreaseSizeCommand implements Command {

    TextModel textModel;

    public void setTextModel(TextModel textModel) {
        this.textModel = textModel;
    }

    @Override
    public void execute() {
        textModel.setTextSize(textModel.getTextSize() + 1);
    }

    @Override
    public void undo() {
        textModel.setTextSize(textModel.getTextSize() - 1);
    }
}
