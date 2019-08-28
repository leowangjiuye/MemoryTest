package com.my.memory.annotation

import com.my.memory.annotation.java.*
import java.util.*

/**
 *
 *
 * @author WangJY
 * create at 2019/8/27
 */

fun main() {
    testRuntimeAnnotation()
//    testSuppressWarnings()
//    testInherited()
}

fun testRuntimeAnnotation() {
    val sampleClass = RunTimeMethodSample::class.java
    val methods = sampleClass.methods
    for (method in methods) {
        val annotationClass = RunTimeAnnotation::class.java
        if (!method.isAnnotationPresent(annotationClass)) {
            continue
        }
        val annotation = method.getAnnotation(annotationClass)
        if (annotation != null) {
            // do something
            val beginTime = System.currentTimeMillis()
            method.invoke(sampleClass.newInstance())
            val endTime = System.currentTimeMillis()
            val time = endTime - beginTime
            println(annotation.methodName + " 方法耗时：" + time + "ms")
        }
    }

    // java提供AbstractProcessor 实现编译期CLASS注解
}
@SuppressWarnings("deprecation")
fun testSuppressWarnings() {
//    deprecation  -- 使用了不赞成使用的类或方法时的警告
//    unchecked    -- 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
//    fallthrough  -- 当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
//    path         -- 在类路径、源文件路径等中有不存在的路径时的警告。
//    serial       -- 当在可序列化的类上缺少 serialVersionUID 定义时的警告。
//    finally      -- 任何 finally 子句不能正常完成时的警告。
//    all          -- 关于以上所有情况的警告。

    //还是有警告？？
    var warnDate = Date(113, 1, 2)
    println("testSuppressWarnings warnDate $warnDate")
}

fun testInherited() {
    for (annotation in UserParent::class.java.annotations) {
        println("UserParent $annotation")
    }
    for (annotation in UserChild::class.java.annotations) {
        println("UserChild $annotation")
    }
    val userParent = UserParent()
    println("userParent.name ${userParent.javaClass.getAnnotation(Name::class.java).defaultValue}")
    println("userParent.phone ${userParent.javaClass.getAnnotation(Phone::class.java).phones}")
}
