package com.example.work.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.work.MainActivity;
import com.example.work.Observer;
import com.example.work.ObserverController;
import com.example.work.TextModel;

public class CustomTextView extends AppCompatTextView implements Observer {
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        MainActivity activity = (MainActivity) context;
        ObserverController observerController = activity.getHandler().getObserverController();
        observerController.addObserverToModel(this);
    }

    @Override
    public void update(TextModel model) {
        setText(String.format("%s", model.getTextSize()));
    }
}
