package com.my.memory.annotation.java;

/**
 * @author WangJY
 * create at 2019/8/28
 */
public class RunTimeMethodSample {

    @RunTimeAnnotation(methodName = "reduce")
    public void reduce() {
        long count = 90000000L;
        while (count > 0) {
            count--;
        }
    }
}
