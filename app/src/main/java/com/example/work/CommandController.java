package com.example.work;

import com.example.work.command.Command;

import java.util.ArrayDeque;

public class CommandController {

    ArrayDeque<Command> stack = new ArrayDeque<>(16);
    private TextModel textModel;

    public CommandController(TextModel textModel) {
        this.textModel = textModel;
    }

    public void addCommand(Command newCommand) {
        stack.addLast(newCommand);
        newCommand.execute(textModel);
    }

    public void undo() {
        stack.pollLast().undo(textModel);
    }
}
