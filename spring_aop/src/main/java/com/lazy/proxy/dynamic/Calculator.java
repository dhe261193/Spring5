package com.lazy.proxy.dynamic;

import org.springframework.stereotype.Service;

/**
* @Author: Lazy小学徒
* @Date: 2022/1/15 23:28
* @Description: 计算器类
*/
@Service
public class Calculator implements ICalculator{
    @Override
    public int sum(int numA, int numB) {

        int result = numA + numB;
        return result;
    }

    @Override
    public int sub(int numA, int numB) throws Exception {
        if (numA < 0) {
            throw new Exception("不能小于0");
        }
        int result = numA - numB;
        return result;
    }

    @Override
    public int mul(int numA, int numB) {
        int result = numA * numB;
        return result;
    }

    @Override
    public int div(int numA, int numB) {
        int result = numA / numB;
        return result;
    }
}
