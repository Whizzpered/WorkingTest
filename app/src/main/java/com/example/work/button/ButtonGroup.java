package com.example.work.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.work.CommandFactory;
import com.example.work.MainActivity;
import com.example.work.ObjectsHandler;
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
    }


    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        if(child instanceof Observer){
            controller.addObserverToModel((Observer)child);
        }
    }

    public CommandFactory getFactory() {
        return factory;
    }
}
