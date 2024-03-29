package com.pm.nio;

import java.nio.ByteBuffer;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/30 08:58
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        System.out.println(buffer.getClass());
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.position(0);
//        readOnlyBuffer.put((byte) 2);
    }
}
