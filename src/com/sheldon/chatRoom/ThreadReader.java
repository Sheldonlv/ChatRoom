package com.sheldon.chatRoom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Sheldon on 2018/11/25.
 * Project Name: Java.
 * Package Name: chatSocket.
 * Description: ‘监听信息’功能模块
 */
public class ThreadReader implements Runnable{

    private InputStream inputStream;

    /**
     * @param inputStream
     */
    public ThreadReader(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public void run(){
        try{
            String message;
            // 创建输入流
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));
            while (true){
                // 监听信息
                message = reader.readLine();
                System.out.println(message);
            }
        }catch (Exception e){

        }
    }
}
