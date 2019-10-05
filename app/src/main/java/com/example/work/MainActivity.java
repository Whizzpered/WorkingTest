package com.example.work;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    ObjectsHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        handler = new ObjectsHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.getTextModel().setContent(getString(R.string.rus_text));
    }

    public ObjectsHandler getHandler(){
        return handler;
    }
}
