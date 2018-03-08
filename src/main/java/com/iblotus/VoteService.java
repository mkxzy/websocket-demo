package com.iblotus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by xiezhiyan on 3/8/18.
 */
@Component
@ServerEndpoint("/ws/vote")
public class VoteService implements Serializable {

    private Logger logger = LoggerFactory.getLogger(VoteService.class);

    private Session session;

    private static Set<VoteService> services = new CopyOnWriteArraySet<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        logger.info("open session " + session.getId());
        this.session = session;
        services.add(this);
        logger.info("count: " + services.size());
    }

    @OnClose
    public void onClose() {
        logger.info("有一连接关闭");
        services.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自客户端的消息:" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误");
        error.printStackTrace();
    }

    @Override
    public int hashCode(){
        return this.session.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof VoteService){
            VoteService socketService = (VoteService) obj;
            return this.session.equals(socketService.session);
        }
        return false;
    }
}
