package com.lazy;

import com.lazy.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class TestTransaction {

    ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring_transaction.xml");
    }

    @Test
    public void testTran() {
        IUserService userService = context.getBean(IUserService.class);
        userService.tran(3, 2, BigDecimal.valueOf(100));
    }
}
