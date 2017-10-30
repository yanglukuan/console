package com.company.stream;

/**
 * Created by yanglk on 2017/7/31.
 */
@FunctionalInterface
/**
 * 函数式接口测试
 */
public interface FlInterface {
    void run(Integer ss);
    default void print(String ss)
    {
        System.out.print(ss);
    }
}
