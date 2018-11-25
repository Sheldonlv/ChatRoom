package com.sheldon.chatRoom;

import java.net.Socket;

/**
 * Created by Sheldon on 2018/11/24.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: 客户端
 */
public class ChatClient {

    private Socket socket;
    private String name;

    /**
     * 发起 Socket 连接
     * @param port
     * @throws Exception
     */
    public ChatClient(int port) throws Exception{
        socket = new Socket("localhost",port);
    }

    /**
     * 开启‘监听信息’‘发送信息’功能的线程
     * @throws Exception
     */
    public void open() throws Exception{
        Thread threadReader = new Thread(new ThreadReader(socket.getInputStream()));
        Thread threadWriter = new Thread(new ThreadWriter(socket.getOutputStream()));
        threadReader.start();
        threadWriter.start();
    }

    public static void main(String[] args) throws Exception{
        ChatClient chatClient = new ChatClient(5432);
        chatClient.open();
    }

}
