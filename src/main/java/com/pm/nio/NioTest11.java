package com.pm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/09/05 19:44
 */
public class NioTest11 {
    public static void main(String[] args) throws IOException {
        //Scattering  分散 读的时候不仅可以传递一个Buffer,同时也可以传递Buffer 数组
        //Gatering  收集 将来自于多个Buffer
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();
        // 死循环 不断的往里面读
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long r = socketChannel.read(buffers);
                byteRead += r;
                System.out.println("byteRead:" + byteRead);
                Arrays.asList(buffers).stream().map(byteBuffer ->
                        "position" + byteBuffer.position() + "," + "limit" + byteBuffer.limit())
                        .forEach(System.out::println);
                Arrays.asList(buffers).forEach(i -> {
                    i.flip();
                });
                //定义读到的长度  并且都写还给客户端
                long byteWrite = 0;
                while (byteWrite < messageLength) {
                    long write = socketChannel.write(buffers);
                    byteWrite += write;
                }
                Arrays.asList(buffers).forEach(byteBuffer -> {
                    byteBuffer.clear();
                });
                System.out.println("byteRead:" + byteRead + ",byteWrite" + byteWrite + ",messageLength:" + messageLength);
            }
        }
    }
}
