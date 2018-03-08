package com.iblotus;

import javax.websocket.Session;

/**
 * Created by xiezhiyan on 3/8/18.
 */
public class VoteObserver implements Observer {

    private Session session;

    public VoteObserver(Session session){
        this.session = session;
    }

    @Override
    public void notify(String message) {
        this.session.getAsyncRemote().sendText(message);
    }
}
