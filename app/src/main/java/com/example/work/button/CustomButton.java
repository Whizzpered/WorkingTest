package com.example.work.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageButton;

import com.example.work.Observer;
import com.example.work.R;
import com.example.work.TextModel;

public class CustomButton extends AppCompatImageButton implements Observer {


    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                pressed();
            }
        });
    }

    public void pressed() {
        ButtonGroup bg = (ButtonGroup)getParent();
        bg.getFactory().createCommand(getId());
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
