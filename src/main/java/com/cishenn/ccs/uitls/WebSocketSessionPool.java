package com.cishenn.ccs.uitls;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Web Socket 会话池
 * @param <T> 用于辨别用户的字段的数据类型（通常即为 <code>id</code> 的数据类型）
 */
@Data
public class WebSocketSessionPool<T> {

    private AtomicInteger onlineCount = new AtomicInteger();

    private ConcurrentHashMap<T, Session> onlineSessions = new ConcurrentHashMap<>();

    /**
     * 向会话池中添加会话（通常为开启 socket 时使用）。
     * @param client  用于辨别用户的字段值（通常即为 <code>id</code>）
     * @param session 会话对象
     */
    public void addSession(T client, Session session) {
        boolean alreadyExists = onlineSessions.containsKey(client);
        onlineSessions.put(client, session);
        if (!alreadyExists) {
            onlineCount.incrementAndGet();
        }
    }

    /**
     * 从会话池中移除会话。
     * @param client 用于辨别用户的字段值（通常即为 <code>id</code>）
     */
    public void removeSession(T client) {
        if (onlineSessions.containsKey(client)) {
            onlineSessions.remove(client);
            onlineCount.decrementAndGet();
        }
    }

    /**
     * 从会话池中移除会话。<b>只有在无法使用 <code>client</code> 移除时才应该使用此方法。</b>
     * @param session 要移除的会话。
     */
    public void removeSession(Session session) {
        for (T client : onlineSessions.keySet(session)) {
            onlineSessions.remove(client);
            onlineCount.decrementAndGet();
        }
    }

    /**
     * 向会话池中的所有会话发送文本消息。
     * @param message 发送的文本消息
     */
    public void broadcast(String message) throws IOException {
        for (Session session : onlineSessions.values()) {
            sendMessage(session, message);
        }
    }

    /**
     * 向会话池中的所有会话发送消息（一个对象，用 JSON 形式发送）
     * @param message 发送的消息
     */
    public void broadcast(Object message) throws IOException {
        for (Session session : onlineSessions.values()) {
            sendMessage(session, new ObjectMapper().writeValueAsString(message));
        }
    }

    /**
     * 向特定用户发送文本消息。
     * @param receiver 消息的接收者
     * @param message  发送的文本消息
     */
    public void sendMessage(T receiver, String message) throws IOException {
        Session session = onlineSessions.get(receiver);
        sendMessage(session, message);
    }

    /**
     * 向特定用户发送消息（一个对象，以 JSON 形式发送）
     * @param receiver 消息的接收者
     * @param message  发送的文本消息
     */
    public void sendMessage(T receiver, Object message) throws IOException {
        Session session = onlineSessions.get(receiver);
        sendMessage(session, new ObjectMapper().writeValueAsString(message));
    }

    private void sendMessage(Session session, String message) throws IOException {
        if (session != null) {
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
}
