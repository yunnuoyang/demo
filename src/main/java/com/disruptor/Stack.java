package com.disruptor;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:51
 * @Description
 **/
public class Stack {

    public static void main(String[] args) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            System.out.println("stackTrace = " + stackTrace[i].getMethodName());
        }
    }
}
