package com.example.work;

import java.util.ArrayList;

public class TextModel implements Observable {

    private String content;
    private boolean bold, italic;
    private int textSize;
    private ArrayList<Observer> observers = new ArrayList<>();

    public TextModel() {

    }

    public void initialize() {
        content = "%s";
        bold = false;
        italic = false;
        textSize = 20;
        update();
    }

    public void setTextSize(int size) {
        if (size > 0) {
            textSize = size;
            update();
        }
    }

    public int getTextSize() {
        return textSize;
    }

    public void setBold() {
        bold = !bold;
        update();
    }

    public void setItalic() {
        italic = !italic;
        update();
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setContent(String s) {
        content = s;
        update();
    }

    public String getContent() {
        return content;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }
}
