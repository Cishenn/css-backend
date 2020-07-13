package com.cishenn.ccs.websocket;

import com.cishenn.ccs.entity.Servicer;
import com.cishenn.ccs.dao.ServicerMapper;
import com.cishenn.ccs.dao.SessionMapper;
import com.cishenn.ccs.entity.SessionWithLatestMessage;
import com.cishenn.ccs.utils.Result;
import com.cishenn.ccs.utils.SpringContextUtils;
import com.cishenn.ccs.utils.WebSocketSessionPool;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServerEndpoint("/session/{id}")
@Component
public class SessionServer {

    private static WebSocketSessionPool<Integer> sessionPool = new WebSocketSessionPool<>();

    private Logger logger = LoggerFactory.getLogger(SessionServer.class);

    private ServicerMapper customerServiceMapper;

    private SessionMapper sessionMapper;

    public static WebSocketSessionPool<Integer> getSessionPool() {
        return sessionPool;
    }

    public SessionServer() {
        customerServiceMapper = SpringContextUtils.getBean(ServicerMapper.class);
        sessionMapper = SpringContextUtils.getBean(SessionMapper.class);
    }

    @OnOpen
    public void onOpen(@PathParam("id") Integer id, Session session) throws IOException {
        Servicer customerService = customerServiceMapper.getOne(id);
        if (customerService == null) {
            session.getBasicRemote().sendText(new ObjectMapper().writeValueAsString(Result.error("该客服不存在")));
            session.close();
        }
        sessionPool.addSession(id, session);
        sendSessionList(id, sessionMapper);
    }

    @OnClose
    public void onClose(@PathParam("id") Integer id) {
        sessionPool.removeSession(id);
    }

    @OnMessage
    public void onMessage(@PathParam("id") Integer id, String message) throws IOException {
        sendSessionList(id, sessionMapper);
    }

    @OnError
    public void onError(Throwable throwable) {
        logError(throwable);
    }

    public static void sendSessionList(Integer id, SessionMapper sessionMapper) throws IOException {
        List<SessionWithLatestMessage> activeSessionsWithLatestMessage = sessionMapper.getWithActiveStatusWithLatestMessage(id, true);
        sessionPool.sendMessage(id, Result.ok(activeSessionsWithLatestMessage) );
    }

    private void logError(Throwable throwable) {
        logger.warn(throwable.getClass().getName() + ": " + throwable.getMessage());
        if (logger.isDebugEnabled()) {
            throwable.printStackTrace();
        }
    }
}
