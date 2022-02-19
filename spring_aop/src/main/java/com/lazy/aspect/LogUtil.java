package com.lazy.aspect;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogUtil {

    /**
    * @Description: 前置通知
    */
    @Before("execution(* com.lazy.service..*.*(..) )")
    public void before() {
        System.out.println("方法执行前");
    }

    /**
     * @Description: 后置返回通知
     */
    @AfterReturning("execution(* com.lazy.service..*.*(..) )")
    public void afterReturn() {
        System.out.println("方法执行返回");
    }

    /**
     * @Description: 后置异常通知
     */
    @AfterThrowing("execution(* com.lazy.service..*.*(..) )")
    public void afterException() {
        System.out.println("方法执行异常");
    }

    /**
     * @Description: 后置通知
     */
    @After("execution(* com.lazy.service..*.*(..) )")
    public void after() {
        System.out.println("方法执行后");
    }

}
