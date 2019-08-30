package com.pm.netty.thrift.generated;

import generated.Person;
import generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/19 19:57
 */
public class ThriftClient {
    public static void main(String[] args) {
        TFramedTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
        TProtocol protocol =new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        try{
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println("---------------");

            Person person2 = new Person();
            person2.setUsername("李四");
            person2.setAge(30);
            person2.setMarried(true);
            client.savePerson(person2);


        }catch (Exception e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            transport.close();
        }
    }
}
