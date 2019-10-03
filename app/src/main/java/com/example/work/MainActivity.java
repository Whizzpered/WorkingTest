package com.example.work;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private TextModel textModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        textModel = new TextModel();
        CommandController.getInstance().setTextModel(textModel);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textModel.setContent(getString(R.string.rus_text));
    }
}
