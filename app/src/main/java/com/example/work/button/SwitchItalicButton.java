package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.work.R;
import com.example.work.TextModel;
import com.example.work.command.SwitchItalicCommand;

public class SwitchItalicButton extends CustomButton {
    public SwitchItalicButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void pressed() {
        commandController.addCommand(new SwitchItalicCommand());
    }

    @Override
    public void update(TextModel model) {
        DrawableCompat.setTint(getDrawable(), ContextCompat.getColor(getContext(), !model.isItalic() ? R.color.original : R.color.colorPrimary));
    }
}
