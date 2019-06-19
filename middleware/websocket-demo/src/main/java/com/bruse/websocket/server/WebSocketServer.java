package com.bruse.websocket.server;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {

    /**
     *  静态变量，用来记录当前在线连接数。应该把它设计成线程安全的
     */
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 服务端 id
     */
    private String sid = "";

    /**
     * 连接建立成功调用的方法
     * @param session 会话
     * @param sid socket id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        this.sid = sid;
        // 加入set
        webSocketSet.add(this);
        onlineCount++;
        System.out.println("有新窗口开始监听:" + sid + ",当前在线人数为" + onlineCount);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        onlineCount--;
        System.out.println("有一连接关闭！当前在线人数为" + onlineCount);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端信息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到来自窗口" + sid + "的信息:" + message);
        // 群发消息
        for (WebSocketServer webSocketServer : webSocketSet) {
            try {
                webSocketServer.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 错误处理
     * @param session 会话
     * @param error 异常
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     * @param message 信息
     * @throws IOException IO Exception
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     * @param message 信息
     * @param sid socket id
     * @throws IOException IO Exception
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        System.out.println("推送消息到窗口" + sid + "，推送内容:" + message);
        for (WebSocketServer webSocketServer : webSocketSet) {
            if (webSocketServer.sid != null && webSocketServer.sid.equals(sid)) {
                try {
                    webSocketServer.sendMessage(message);
                } catch (IOException e) {
                    continue;
                }
            }
        }
    }
}
