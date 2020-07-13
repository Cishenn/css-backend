package com.cishenn.ccs.websocket;

import com.cishenn.ccs.dao.SessionMsgMapper;
import com.cishenn.ccs.entity.SessionMsg;
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
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/session/{sessionId}/message")
public class SessionMsgServer {

    private static ConcurrentHashMap<Integer, WebSocketSessionPool<Integer>> sessionPools = new ConcurrentHashMap<>();

    private final Logger logger = LoggerFactory.getLogger(SessionMsgServer.class);

    private SessionMsgMapper sessionMsgMapper;

    public SessionMsgServer() {
        sessionMsgMapper = SpringContextUtils.getBean(SessionMsgMapper.class);
    }

    @OnOpen
    public void onOpen(@PathParam("sessionId") Integer sessionId, Session session) {
        if (!sessionPools.containsKey(sessionId)) {
            sessionPools.put(sessionId, new WebSocketSessionPool<>());
        }
        WebSocketSessionPool<Integer> sessionPool = sessionPools.get(sessionId);
        sessionPool.addSession(sessionPool.getOnlineCount().intValue(), session);
    }

    @OnClose
    public void onClose(@PathParam("sessionId") Integer sessionId, Session session) {
        if (!sessionPools.containsKey(sessionId)) {
            logger.warn("Unexpected session id " + sessionId + " on closing websocket");
            return;
        }
        sessionPools.get(sessionId).removeSession(session);
        if (sessionPools.get(sessionId).getOnlineSessions().isEmpty()) {
            sessionPools.remove(sessionId);
        }
    }

    @OnMessage
    public void onMessage(@PathParam("sessionId") Integer sessionId, Session session, String message) throws IOException {
        try {
            if (!sessionPools.containsKey(sessionId)) {
                logger.warn("Unexpected session id " + sessionId + " on receiving message");
                session.getBasicRemote().sendText(new ObjectMapper().writeValueAsString(Result.error("不存在的 session id")));
            }
            SessionMsg sessionMsg = new ObjectMapper().readValue(message, SessionMsg.class);
            sessionMsg.setSessionId(sessionId);
            sessionMsgMapper.insert(sessionMsg);
            sessionPools.get(sessionId).broadcast(Result.ok(sessionMsg));
        } catch (Exception e) {
            logThrowable(e);
            session.getBasicRemote().sendText(new ObjectMapper().writeValueAsString(Result.error(e.getClass().getName() + ": " + e.getMessage())));
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        logThrowable(throwable);
    }

    private void logThrowable(Throwable throwable) {
        logger.warn(throwable.getClass().getName() + ": " + throwable.getMessage());
        if (logger.isWarnEnabled()) {
            throwable.printStackTrace();
        }
    }
}
