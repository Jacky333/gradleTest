package com.pm.decorator;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/24 09:20
 */
public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }

    private void doAnotherThing() {
        System.out.println("功能B");
    }
}
