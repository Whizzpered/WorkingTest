package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.work.R;
import com.example.work.TextModel;
import com.example.work.command.SwitchBoldCommand;

public class SwitchBoldButton extends CustomButton {
    public SwitchBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void pressed() {
        commandController.addCommand(new SwitchBoldCommand());
    }

    @Override
    public void update(TextModel model) {
        DrawableCompat.setTint(getDrawable(), ContextCompat.getColor(getContext(), !model.isBold() ? R.color.original : R.color.colorPrimary));
    }
}
