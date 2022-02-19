package com.lazy.proxy.dynamic;

public interface ICalculator {

    //加
    public int sum(int numA, int numB);

    //减
    public int sub(int numA, int numB) throws Exception;

    //乘
    public int mul(int numA, int numB);

    //除
    public int div(int numA, int numB);
}
