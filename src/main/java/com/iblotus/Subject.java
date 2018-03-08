package com.iblotus;

/**
 * Created by xiezhiyan on 3/8/18.
 */
public interface Subject {

    void add(Observer observer);

    void remove(Observer observer);

    void update();
}
