package com.peach.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by panta on 2017/12/8.
 */
public class DemoFileChannel {

    public static void main(String[] args) {
        RandomAccessFile file = null;
        FileChannel channel =  null;
        try {
            file = new RandomAccessFile("F:\\demo.txt","rw");
            channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int data = channel.read(byteBuffer);
            while (data != -1){
                System.out.print(data);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char)byteBuffer.get());
                }
                byteBuffer.clear();
                data = channel.read(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (file != null){
                try {
                    file.close();
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
