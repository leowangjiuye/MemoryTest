package com.my.memory.test;

/**
 * @author WangJY
 * create at 2019/5/13
 */
interface OnResultListener {
    // 默认public final static
    int code = 1;
    //默认abstract
    void onSuccess();

//    //JAVA 8 OK
//    static void onError(){
//
//    }
//
//    //JAVA 8 OK
//    default void onProgress() {
//
//    }
}
