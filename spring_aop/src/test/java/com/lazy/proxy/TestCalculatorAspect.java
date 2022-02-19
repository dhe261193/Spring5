package com.lazy.proxy;

import com.lazy.proxy.dynamic.ICalculator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalculatorAspect {

    ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring_aop.xml");
    }

    @Test
    public void testAfterReturning() {
        ICalculator calculator = context.getBean(ICalculator.class);
        int sum = calculator.sum(3, 5);
        System.out.println("---sum结果：" + sum);
    }

    @Test
    public void testAfterThrowing() {
        ICalculator calculator = context.getBean(ICalculator.class);
        int sum = 0;
        try {
            sum = calculator.sub(-1, 5);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        System.out.println("---sum结果：" + sum);
    }
}
