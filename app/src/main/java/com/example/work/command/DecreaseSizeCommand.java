package com.example.work.command;

import com.example.work.TextModel;

public class DecreaseSizeCommand implements Command {

    @Override
    public void execute(TextModel textModel) {
        textModel.setTextSize(textModel.getTextSize() - 1);
    }

    @Override
    public void undo(TextModel textModel) {
        textModel.setTextSize(textModel.getTextSize() + 1);
    }
}
