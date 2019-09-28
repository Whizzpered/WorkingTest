package com.example.work.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageButton;

import com.example.work.CommandController;
import com.example.work.Observer;

public abstract class CustomButton extends AppCompatImageButton  implements Observer {

    CommandController commandController;

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressed();
            }
        });
        commandController = CommandController.getInstance();
        commandController.addObserverToModel(this);
    }

    public abstract void pressed();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
