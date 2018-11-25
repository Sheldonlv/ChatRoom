package com.sheldon.chatRoom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sheldon on 2018/11/24.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: 服务端
 */
public class ChatServer {

    /**
     * 服务器创建
     * @param port
     * @throws IOException
     */
    public ChatServer(int port) throws IOException{
        // 创建服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器创建成功！port = " + port);
        while (true){
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("新用户进入该聊天室");
            // 启动线程管理该socket
            ThreadServerSocket threadSocket = new ThreadServerSocket(socket);
            threadSocket.start();
        }
    }

    public static void main(String[] args) throws IOException{
        ChatServer chatServer = new ChatServer(5432);
    }
}
