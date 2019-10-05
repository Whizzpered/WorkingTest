package com.example.work.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.work.Observer;
import com.example.work.TextModel;

public class CustomTextView extends AppCompatTextView implements Observer {
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void update(TextModel model) {
        setText(String.format("%s", model.getTextSize()));
    }
}
