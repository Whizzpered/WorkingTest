package com.example.work.command;

import com.example.work.TextModel;

public class SwitchItalicCommand implements Command {

    TextModel textModel;

    public void setTextModel(TextModel textModel) {
        this.textModel = textModel;
    }

    @Override
    public void execute() {
        textModel.setItalic();
    }

    @Override
    public void undo() {
        textModel.setItalic();
    }
}
