package com.my.memory.kotlin


/**
 *
 *
 * @author WangJY
 * create at 2019/4/21
 */
fun main() {

    // 可以省略分号
    val name = "World"
    printTest(name)
    //扩展函数
    printTest(name.firstChar())
    safeVal()
    firstClass()
}



// 类型后置
fun printTest(args: String) {
    // 直接支持字符串模板
    println("Hello $args!")
}

// 给String类型扩展了一个函数,怎么跨类调用？
fun String.firstChar(): String {
    if (this == null || this.isEmpty()) {
        return ""
    }
    return this[0].toString()
}

fun safeVal() {
    //不可空类型
    val nonNull = ""
    nonNull.firstChar()
    //空安全
    val empty: String? = null
    //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    //empty.firstChar()//error
    empty?.firstChar()//correct if null do nothing?
    empty!!.firstChar()//correct if null throw exception
}

// 一等函数
fun firstClass(): Any? {
    val word = "W is keywords"
    var text = "has letter W"
    var x: Int = 1
    when(x) {
    }
    // 函数可以作为参数
    val result = text.containChar { word.firstChar() }
    println("result is $result")
    return null
}

fun String.containChar(key: () -> String): Boolean {
    if (this == null || this.isEmpty()) {
        return false
    }
    return this.indexOf(key.invoke(), 0, false) != -1
}