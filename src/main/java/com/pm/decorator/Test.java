package com.pm.decorator;

/**
 * @author pengcheng
 * @version V1.0
 * @description \
 * @date 2019/08/24 09:23
 */
public class Test {
    public static void main(String[] args) {
        Component component
                = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.doSomething();
    }

}
