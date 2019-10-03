package com.example.work.command;

import com.example.work.TextModel;

public class SwitchItalicCommand implements Command {

    @Override
    public void execute(TextModel textModel) {
        textModel.setItalic();
    }

    @Override
    public void undo(TextModel textModel) {
        textModel.setItalic();
    }
}
