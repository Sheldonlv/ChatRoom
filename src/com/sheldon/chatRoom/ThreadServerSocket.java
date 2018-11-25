package com.sheldon.chatRoom;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sheldon on 2018/11/25.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: 服务端的‘Socket’管理模块
 */
public class ThreadServerSocket extends Thread{

    private Socket socket;
    private String name;
    private BufferedWriter writer;
    private BufferedReader reader;

    /**
     * 构造器
     * @param socket
     */
    public ThreadServerSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            String message;
            // 向客户端询问身份
            message = "欢迎你的到来，请告诉我你的名字：";
            writer.write(message + "\n");
            writer.flush();
            // 收取回复,登记用户，添加进聊天队伍中
            name = reader.readLine();
            System.out.println("新用户叫："+name);
            // 告知客户端已经知道他的名字了
            writer.write(String.format("用户%s，您可以参与互动了 （当前人数%d）\n",name,ChatServerTool.size()+1));
            writer.flush();
            ChatServerTool.addSocket(this);
            System.out.println("已添加进队列");
            // 监听消息，并群发
            while (true){
                message = reader.readLine();
                System.out.println(String.format("%s 说：%s",name ,message));
                ChatServerTool.sendAll(name,message);
            }
        }catch (IOException e){
        }catch (Exception ee){
        }
    }

    public BufferedWriter getWriter() {
        return writer;
    }

}
