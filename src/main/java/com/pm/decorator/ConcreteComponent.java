package com.pm.decorator;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/24 09:16
 */
public class ConcreteComponent implements Component{

    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
