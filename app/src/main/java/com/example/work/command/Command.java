package com.example.work.command;

import com.example.work.TextModel;

public interface Command {

    void setTextModel(TextModel target);
    void execute();
    void undo();

}
