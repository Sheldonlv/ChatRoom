package com.sheldon.chatRoom;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by Sheldon on 2018/11/25.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: ‘发送信息’功能模块
 */
public class ThreadWriter implements Runnable{

    private OutputStream outputStream;
    private String name;

    /**
     * @param outputStream
     */
    public ThreadWriter(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(){
        try{
            Scanner scanner = new Scanner(System.in);
            String message;
            while (true){
                // 创建输出流
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream));
                // 发送的内容
                message = scanner.nextLine();
                // 发送信息
                writer.write(message + "\n");
                writer.flush();
            }
        }catch (IOException e){
        }
    }
}
