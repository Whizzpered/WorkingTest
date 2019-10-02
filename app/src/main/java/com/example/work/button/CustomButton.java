package com.example.work.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageButton;

import com.example.work.CommandController;
import com.example.work.Observer;
import com.example.work.R;
import com.example.work.TextModel;

public class CustomButton extends AppCompatImageButton implements Observer {

    CommandController commandController;

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new CustomOnClickListener());
        commandController = CommandController.getInstance();
        commandController.addObserverToModel(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void update(TextModel model) {
        int thisId = getId();
        switch (thisId) {
            case (R.id.boldButton):
                setActivated(model.isBold());
                break;
            case (R.id.italicButton):
                setActivated(model.isItalic());
                break;
        }
    }
}
