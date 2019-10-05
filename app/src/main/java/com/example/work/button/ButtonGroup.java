package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.work.CommandFactory;
import com.example.work.MainActivity;
import com.example.work.Observer;
import com.example.work.ObserverController;

public class ButtonGroup extends ConstraintLayout {

    CommandFactory factory;
    ObserverController controller;

    public ButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        MainActivity activity = (MainActivity) context;
        factory = activity.getHandler().getCommandFactory();
        controller = activity.getHandler().getObserverController();
        setObservers();
    }

    public void setObservers() {
        for (int i = 0; i < getChildCount(); i++) {
            Observer child = (Observer) getChildAt(i);
            controller.addObserverToModel(child);
        }
    }

    public ObserverController getController() {
        return controller;
    }

    public CommandFactory getFactory() {
        return factory;
    }
}
