package com.pm.netty.thrift.generated;

import generated.DataException;
import generated.Person;
import generated.PersonService;
import org.apache.thrift.TException;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/19 19:41
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param" + username);
        Person person = new Person();
        person.setUsername(username);
        person.setMarried(false);
        person.setAge(20);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
