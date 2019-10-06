package com.example.work;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements Handler{

    ObjectsHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        handler = new ObjectsHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.getTextModel().setContent(getString(R.string.rus_text));
    }

    @Override
    public ObjectsHandler getHandler(){
        return handler;
    }
}
