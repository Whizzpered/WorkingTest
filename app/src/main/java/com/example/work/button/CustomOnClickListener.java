package com.example.work.button;

import android.view.View;

import com.example.work.CommandController;
import com.example.work.R;
import com.example.work.command.Command;
import com.example.work.command.DecreaseSizeCommand;
import com.example.work.command.EmptyCommand;
import com.example.work.command.IncreaseSizeCommand;
import com.example.work.command.SwitchBoldCommand;
import com.example.work.command.SwitchItalicCommand;

public class CustomOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {

        int thisId = view.getId();
        Command command = new EmptyCommand();
        CommandController commandController = CommandController.getInstance();
        switch (thisId) {
            case (R.id.boldButton):
                command = new SwitchBoldCommand();
                break;
            case (R.id.italicButton):
                command = new SwitchItalicCommand();
                break;
            case (R.id.decreaseButton):
                command = new DecreaseSizeCommand();
                break;
            case (R.id.increaseButton):
                command = new IncreaseSizeCommand();
                break;
        }
        commandController.addCommand(command);
    }
}
