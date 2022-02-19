package com.lazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Dynamichandler implements InvocationHandler {

    //被代理的对象
    private Object target;

    public Dynamichandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("----调用了【" + method.getName() + "】方法----");
        if (args != null && args.length > 0) {
            System.out.println("----参数是：" + Arrays.asList(args));
        } else {
            System.out.println("----没有参数----");
        }


        /*
        * 执行被代理的方法
        * 参数：target - 被代理的对象  args - 被代理的方法参数
        */
        Object result = method.invoke(target, args);
        if (result == null) {
            System.out.println("----方法执行结束，无返回值");
        } else {
            System.out.println("----方法执行结束，结果是：" + result);
        }

        return result;
    }
}
