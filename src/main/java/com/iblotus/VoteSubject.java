package com.iblotus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiezhiyan on 3/8/18.
 */
@Component
public class VoteSubject implements Subject {

    private Logger logger = LoggerFactory.getLogger(VoteSubject.class);

    private Set<Observer> observers = new HashSet<>();

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
        logger.info(String.valueOf(observers.size()));

    }

    @Override
    public void remove(Observer observer) {
        this.observers.remove(observer);
        logger.info(String.valueOf(observers.size()));
    }

    @Override
    public void update() {
        for(Observer o: observers){
            o.notify("Hello, World!");
        }
    }
}
