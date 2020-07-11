package com.cishenn.ccs.websocket;

import com.cishenn.ccs.uitls.WebSocketSessionPool;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/example/{username}")
@Component
public class ExampleServer {

    private static WebSocketSessionPool<String> sessionPool = new WebSocketSessionPool<>();

    public static WebSocketSessionPool<String> getSessionPool() {
        return sessionPool;
    }

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        sessionPool.addSession(username, session);
        try {
            sessionPool.broadcast("The server welcomes " + username + " into the chat room! " +
                    "Currently there are " + sessionPool.getOnlineCount() + " member(s).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(@PathParam("username") String username) {
        sessionPool.removeSession(username);
        try {
            sessionPool.broadcast(username + " exits the chat room. " +
                    "Currently there are " + sessionPool.getOnlineCount() + " member(s).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        String receiver = null;
        if (message != null && message.contains("@")) {
            int receiverIndex = message.indexOf("@");
            receiver = message.substring(receiverIndex + 1);
            message = message.substring(0, receiverIndex);
        }
        try {
            if (receiver == null) {
                sessionPool.broadcast("[" + username + " to all] " + message);
            } else if (sessionPool.getOnlineSessions().containsKey(receiver)) {
                sessionPool.sendMessage(receiver, "[" + username + " to " + receiver + "] " + message);
            } else {
                sessionPool.sendMessage(username, "[" + username + " to " + receiver + " (not found)] " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

}
