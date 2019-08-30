package com.pm.decorator;

/**
 * @author pengcheng
 * @version V1.0
 * @description
 * @date 2019/08/24 09:18
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
