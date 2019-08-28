package com.my.memory.classandobj

import com.my.memory.kotlin.EasyInterface

/**
 *
 *
 * @author WangJY
 * create at 2019/8/1
 */
class TopClass {
    val index = 1
    //嵌套类
    class TopNesting {
        val content = 0
        fun printSomeThing() {
            //类似于Java的静态内部类
            //println("TopNesting print ${index}")
        }
    }

    //嵌套类
    class TopNesting2 {
        val ting: TopNesting = TopNesting();
        fun printSomeThing() {
            //类似于Java的静态内部类
            //println("TopNesting print ${index}")
            println(ting.content)
        }
    }

    //内部类
    inner class TopInner {
        fun printSomeThing() {
            //类似于Java的成员内部类
            println("TopNesting print ${index}")
        }
    }

}
