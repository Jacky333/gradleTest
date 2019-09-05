package com.pm.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author pengcheng
 * @version V1.0
 * @description directByteBuffer
 * @date 2019/09/05 19:19
 */
public class NioTest8 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("input2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
        long start = System.currentTimeMillis();
        while (true) {
            byteBuffer.clear();
            int read = inputChannel.read(byteBuffer);
            System.out.println(read);
            if (-1 == read) {
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        inputChannel.close();
        outputChannel.close();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
