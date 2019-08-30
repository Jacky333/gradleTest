package com.pm.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/15 19:51
 */
public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三")
                .setAge(20).setAddress("北京").build();
        byte[] studentBytes = student.toByteArray();
        DataInfo.Student student2 = DataInfo.Student.parseFrom(studentBytes);
        System.out.println(student2);
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}
