package com.lazy.proxy;

import com.lazy.proxy.dynamic.Calculator;
import com.lazy.proxy.dynamic.ICalculator;
import com.lazy.proxy.staticproxy.GameProxyPlayer;
import com.lazy.proxy.staticproxy.IGamePlayer;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {

    @Test
    public void testCalculator() {

        //类加载器，通常指定被代理类的接口的类加载器
        ClassLoader classLoader = ICalculator.class.getClassLoader();
        //类型，通常指定被代理类的接口类型
        Class<?>[] interfaces = new Class[]{ICalculator.class};
        //传入被代理的对象
        InvocationHandler handler = new Dynamichandler(new Calculator());
        //动态创建代理类
        ICalculator o = (ICalculator) Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println("----代理类：" + o.getClass());
        //调用
        int sum = o.sum(3, 5);
        System.out.println("----调用结果：" + sum);

    }

    /**
    * @Description: 公共JDK动态代理生成
    */
    public static Object createProxy(Object needProxy) {
        //类加载器，通常指定被代理类的接口的类加载器
        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        //类型，通常指定被代理类的接口类型
        Class<?>[] interfaces = needProxy.getClass().getInterfaces();
        //传入被代理的对象
        InvocationHandler handler = new Dynamichandler(needProxy);
        //动态创建代理类
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        return o;
    }

    @Test
    public void testDynamic() {
        ICalculator calculator = (ICalculator) createProxy(new Calculator());
        calculator.mul(3, 6);

        System.out.println("");

        IGamePlayer player = (IGamePlayer) createProxy(new GameProxyPlayer("小学徒"));
        player.start();
        player.play();
    }
}
