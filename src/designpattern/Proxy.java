package designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Random;

public class Proxy {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        Moveable m = (Moveable) java.lang.reflect.Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        m.move();
    }
}

interface Moveable{
    void move() throws Exception;
}

class Car implements  Moveable {
    @Override
    public void move() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        System.out.println("running");
    }
}

class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("car start running");
        method.invoke(target, args);
        long stop = System.currentTimeMillis();
        System.out.println("time is" + (stop-start));
        return null;
    }
}