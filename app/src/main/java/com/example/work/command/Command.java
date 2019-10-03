package com.example.work.command;

import com.example.work.TextModel;

public interface Command {

    void execute(TextModel target);
    void undo(TextModel target);

}
