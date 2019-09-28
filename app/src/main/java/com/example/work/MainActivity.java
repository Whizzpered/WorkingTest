package com.example.work;

import android.app.Activity;
import android.os.Bundle;

import com.example.work.view.CustomTextView;

public class MainActivity extends Activity {

    private TextViewer textViewer;
    private TextModel textModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        textModel = new TextModel();
        CommandController.getInstance().setTextModel(textModel);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewer = findViewById(R.id.textviewer);
        CommandController.getInstance().addObserverToModel(textViewer);
        CustomTextView vs = findViewById(R.id.font_size_indicator);
        vs.setText(String.format("%s", 20));

        CommandController.getInstance().addObserverToModel(textViewer);
        CommandController.getInstance().addObserverToModel(vs);

        textModel.initialize();
        textModel.setContent(getString(R.string.rus_text));
    }
}
