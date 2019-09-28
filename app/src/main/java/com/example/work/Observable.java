package com.example.work;

public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void update();
}
