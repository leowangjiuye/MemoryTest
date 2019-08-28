package com.my.memory.classandobj;


import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import com.my.memory.kotlin.EasyInterface;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author WangJY
 * create at 2019/8/1
 */
public class EnumJ {
    //只要一个类的对象是有限且固定的，就可以使用枚举
    enum DeviceJ implements EasyInterface {
        //没有class关键字
        A8,
        C10;

        @Override
        public void easy(@NotNull String result) {
            System.out.println("easy " + result);
        }
    }

    enum DeviceWithAbstractMethod {
        //没有class关键字
        A8 {
            @Override
            public void printDevice() {
                System.out.println("System.out:A8");
            }
        },
        C10 {
            @Override
            public void printDevice() {
                System.out.println("System.out:C10");
            }
        };

        public abstract void printDevice();
    }

    @IntDef({Sex.MAN, Sex.WOMAN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Sex {
        // 默认public static final
        int MAN = 0;
        int WOMAN = 1;
        String describe() default "man";
    }

    public void setSex(@Sex int sex) {

    }

    public void main() {
        setSex(Sex.MAN);
    }

}
