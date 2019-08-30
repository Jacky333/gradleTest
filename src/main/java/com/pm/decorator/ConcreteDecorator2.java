package com.pm.decorator;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/24 09:22
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("功能C");
    }
}
