package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;

import com.example.work.TextModel;
import com.example.work.command.IncreaseSizeCommand;

public class IncreaseSizeButton extends CustomButton {
    public IncreaseSizeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void pressed() {
        commandController.addCommand(new IncreaseSizeCommand());
    }

    @Override
    public void update(TextModel model) {

    }
}
