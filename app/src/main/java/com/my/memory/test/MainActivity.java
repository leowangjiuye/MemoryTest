package com.my.memory.test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Object> listLeak;
    private static InnerClass nonStaticInnerClassLeak;
    private Handler handlerLeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        testHandleLeak();
//        testInnerThread();
//        testNonStaticInnerClass();
//        testStaticContext();
//        testListLeak();
    }

    private void testHandleLeak() {
        handlerLeak = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //耗时操作，这个过程，不能回收。
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                handlerLeak.sendMessage(message);
            }
        }).start();
    }


    private void testInnerThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //非静态内部类，默认持有外部引用，运行过程，无法释放。
                try {
                    Thread.sleep(120 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void testNonStaticInnerClass() {
        if (nonStaticInnerClassLeak == null) {
            //非静态内部类的实例的引用
            nonStaticInnerClassLeak = new InnerClass();
        }
        //销毁activity,并gc后仍然存在引用。
    }
    private class InnerClass {

    }


    private void testStaticContext() {
        //error code；activity销毁,并gc后，profiler仍然有该activity
        StaticTest.context = this;
    }

    private void testListLeak() {
        listLeak = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            Object[] objs = new Object[1024];
            listLeak.add(objs);
        }
        // error code
//        for (Object o : listLeak) {
//            o = null;
//        }
        // correct code; profiler中没有listLeak
        listLeak.clear();
        listLeak = null;
    }
}
