package com.my.memory.annotation.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author WangJY
 * create at 2019/8/27
 */
/**
 * 包含在javadoc中，注解默认不在javadoc
 * 只能标注“Annotation类型”
 */
@Documented
/** 保存策略
 * 只能标注“Annotation类型”
 * RetentionPolicy.SOURCE,    Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了
 * RetentionPolicy.CLASS,     编译器将Annotation存储于类对应的.class文件中。默认行为
 * RetentionPolicy.RUNTIME    编译器将Annotation存储于class文件中，并且可由JVM读入
 */
@Retention(RetentionPolicy.RUNTIME)
/** 属性，使用该注解的对象
 * 只能标注“Annotation类型”
 * ElementType.TYPE,               类、接口（包括注释类型）或枚举声明
 * ElementType.FIELD,              字段声明（包括枚举常量）
 * ElementType.METHOD,             方法声明
 * ElementType.PARAMETER,          参数声明
 * ElementType.CONSTRUCTOR,        构造方法声明
 * ElementType.LOCAL_VARIABLE,     局部变量声明
 * ElementType.ANNOTATION_TYPE,    注释类型声明
 * ElementType.PACKAGE             包声明
 */
@Target(ElementType.ANNOTATION_TYPE)
/**
 * 注解的继承性
 * 只能标注“Annotation类型”
 */
@Inherited
/**
 * @interface 表示注解，可以认为是一个关键字
 * 实现了 java.lang.annotation.Annotation 接口
 */
public @interface RootAnnotation {
}
