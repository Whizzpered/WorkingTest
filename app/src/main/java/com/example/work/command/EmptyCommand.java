package com.example.work.command;

import com.example.work.TextModel;

public class EmptyCommand implements Command {

    @Override
    public void execute(TextModel textModel) {
    }

    @Override
    public void undo(TextModel textModel) { }
}
