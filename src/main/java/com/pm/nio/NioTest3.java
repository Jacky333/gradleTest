package com.pm.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/24 11:19
 */
public class NioTest3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        String str = "hello world welcome,nihao";
        byte[] messages = str.getBytes();
        for (int i = 0; i < messages.length; i++) {
            byteBuffer.put(messages[i]);
        }
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
