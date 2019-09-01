package com.example.work;

public class TextModel {

    private String content;
    private boolean bold, italic;
    private int textSize;


    public TextModel(){
        content = "%s";
        bold = false;
        italic = false;
        textSize = 20;
    }

    public void setTextSize(int size){
        if(size > 0){
            textSize = size;
        }
    }

    public int getTextSize(){
        return textSize;
    }

    public void setBold(){
        bold = !bold;
    }

    public void setItalic(){
        italic = !italic;
    }

    public boolean isBold(){
        return bold;
    }

    public boolean isItalic(){
        return italic;
    }

    public void setContent(String s){
        content = s;
    }

    public String getContent(){
        return content;
    }
}
