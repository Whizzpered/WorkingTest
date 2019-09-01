package com.example.work;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class MainActivity extends Activity {

    private TextViewer textViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewer = findViewById(R.id.textviewer);
        TextView vs = findViewById(R.id.font_size_indicator);
        vs.setText(String.format("%s", textViewer.getTextSize()));
    }


    public void boldButtonPressed(View view) {
        final ImageButton boldButton = findViewById(R.id.boldButton);
        boolean isBold = textViewer.isBold();
        textViewer.setFormating(TextViewer.FormatType.BOLD);
        DrawableCompat.setTint(boldButton.getDrawable(), ContextCompat.getColor(getApplicationContext(), isBold ? R.color.original : R.color.colorPrimary));
    }

    public void italicButtonPressed(View view) {
        final ImageButton italicButton = findViewById(R.id.italicButton);
        boolean isItalic = textViewer.isItalic();
        textViewer.setFormating(TextViewer.FormatType.ITALIC);
        DrawableCompat.setTint(italicButton.getDrawable(), ContextCompat.getColor(getApplicationContext(), isItalic ? R.color.original : R.color.colorPrimary));
    }

    public void decreaseButtonPressed(View view) {
        TextView vs = findViewById(R.id.font_size_indicator);
        int newSize = textViewer.getTextSize() - 1;
        if (newSize >= 1) {
            vs.setText(String.format("%s", newSize));
            textViewer.setTextSize(newSize);
        }
    }

    public void increaseButtonPressed(View view) {
        TextView vs = findViewById(R.id.font_size_indicator);
        int newSize = textViewer.getTextSize() + 1;
        vs.setText(String.format("%s", newSize));
        textViewer.setTextSize(newSize);
    }
}
