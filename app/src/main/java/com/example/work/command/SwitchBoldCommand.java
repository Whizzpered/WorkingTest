package com.example.work.command;

import com.example.work.TextModel;

public class SwitchBoldCommand implements Command {

    @Override
    public void execute(TextModel textModel) {
        textModel.setBold();
    }

    @Override
    public void undo(TextModel textModel) {
        textModel.setBold();
    }
}
