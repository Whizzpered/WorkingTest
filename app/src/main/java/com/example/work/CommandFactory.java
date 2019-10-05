package com.example.work;

import android.util.SparseArray;
import com.example.work.command.*;

public class CommandFactory {

    SparseArray<Command> commands = new SparseArray<>();
    CommandController controller;

    public CommandFactory(CommandController commandController) {
        commands.put(R.id.boldButton, new SwitchBoldCommand());
        commands.put(R.id.italicButton, new SwitchItalicCommand());
        commands.put(R.id.decreaseButton, new DecreaseSizeCommand());
        commands.put(R.id.increaseButton, new IncreaseSizeCommand());
        controller = commandController;
    }

    public void createCommand(int id) {
        controller.addCommand(commands.get(id));
    }

}
