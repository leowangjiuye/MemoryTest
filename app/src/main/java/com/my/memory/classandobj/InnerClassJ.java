package com.my.memory.classandobj;

import android.view.View;

/**
 * @author WangJY
 * create at 2019/8/1
 */
public class InnerClassJ {
    //静态内部类（嵌套类）
    static class StaticNestedClass {
        //只能访问外部类的静态方法或静态成员
    }
    //成员内部类
    class InnerClass {
        //持有对外部类的引用
    }
    //局部内部类
    public void someMethod(){
        class localClass{
        }
    }
    //匿名内部类
    Object obj = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
