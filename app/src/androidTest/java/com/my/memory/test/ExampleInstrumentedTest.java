package com.my.memory.test;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.my.memory.annotation.java.UserChild;
import com.my.memory.annotation.java.UserParent;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.annotation.Annotation;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.my.memory.test", appContext.getPackageName());
    }

    @Test
    public void testUser() {
        for (Annotation annotation : UserParent.class.getAnnotations()) {
            System.out.println("UserParent " + annotation);
        }
        for (Annotation annotation : UserChild.class.getAnnotations()) {
            System.out.println("UserChild " + annotation);
        }
        Date warnDate = new Date(113, 1, 2);
        System.out.println("testSuppressWarnings warnDate " + warnDate);
    }

}
