package com.sheldon.chatRoom;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sheldon on 2018/11/25.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: 服务端的‘Socket’管理模块的组件
 */
public class ChatServerTool {

    private static ArrayList<ThreadServerSocket> socketList = new ArrayList();

    private ChatServerTool(){}

    public static void addSocket(ThreadServerSocket socket){
        socketList.add(socket);
    }

    /**
     * 群发消息功能模块
     * @param name
     * @param message
     * @throws IOException
     */
    public static void sendAll(String name,String message) throws IOException{
        // 编辑消息
        message = String.format("%s说：%s （当前人数%d）", name,message,socketList.size());
        // ‘服务端’向‘客户端’群发消息
        for (int i = 0; i < socketList.size(); i++){
            ThreadServerSocket socket = socketList.get(i);
            socket.getWriter().write(message + "\n");
            socket.getWriter().flush();
        }
    }

    /**
     * 返回聊天室当前人数
     * @return
     */
    public static int size(){
        return socketList.size();
    }

}
