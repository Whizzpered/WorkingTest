package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;

import com.example.work.TextModel;
import com.example.work.command.DecreaseSizeCommand;

public class DecreaseSizeButton extends CustomButton {
    public DecreaseSizeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void pressed() {
        commandController.addCommand(new DecreaseSizeCommand());
    }

    @Override
    public void update(TextModel model) {

    }
}
