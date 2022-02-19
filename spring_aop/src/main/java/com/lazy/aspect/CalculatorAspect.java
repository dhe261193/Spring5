package com.lazy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/18 23:15
* @Description:
*/
@Component
@Aspect
public class CalculatorAspect {

    @Pointcut("execution(* com.lazy.proxy.dynamic..*(..) )")
    public void point() {

    }

    @Before("point()")
    public void before(JoinPoint joinPoint) {
        System.out.println("****************方法执行前*****************");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---方法名：" + methodName);
        Object[] args = joinPoint.getArgs();
        System.out.println("---参数是：" + Arrays.asList(args));
    }

    @AfterReturning(value = "point()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("****************方法执行返回*****************");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---方法名：" + methodName);
        System.out.println("---方法执行完成，返回值是：" + result);
    }

    @AfterThrowing(value = "point()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("****************方法执行异常*****************");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---方法名：" + methodName);
        System.out.println("---方法执行异常，异常是：" + ex.getMessage());
    }

    @After(value = "point()")
    public void after(JoinPoint joinPoint) {
        System.out.println("****************方法执行完成*****************");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---方法名：" + methodName);
    }

    /**
    * @Description: 环绕通知
    */
    @Around(value = "point()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object proceed = null;
        try {
            System.out.println("##########  方法环绕前置通知，方法名：" + methodName + " #####  参数：" + Arrays.asList(args));
            //利用反射调用目标方法，就是method.invoke()
            proceed = joinPoint.proceed(args);
            System.out.println("##########  方法环绕后置返回通知，返回值：" + proceed );
        } catch (Throwable throwable) {
            System.out.println("##########  方法环绕后置异常通知，返回值：" + throwable.getMessage() );
        } finally {
            System.out.println("##########  方法环绕后置通知，方法名：" + methodName );
        }
        return proceed;
    }
}
