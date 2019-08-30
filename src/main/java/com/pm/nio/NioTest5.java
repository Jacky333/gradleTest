package com.pm.nio;

import java.nio.ByteBuffer;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/30 08:40
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(15);
        byteBuffer.putLong(5000000000L);
        byteBuffer.putDouble(14.2356);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short) 2);
        byteBuffer.putChar('我');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());
    }
}
