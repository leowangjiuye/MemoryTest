package com.my.memory.classandobj

/**
 *
 *
 * @author WangJY
 * create at 2019/8/2
 */
//无子类时，字节码上仅私有构造函数
sealed class POS

//class A8(val name: String) : POS()
//class C10(val name: String) : POS()
//class C9(val name: String) : POS()
//class P990(val name: String) : POS()

fun main() {
//    println(getDeviceName(A8("[A8]")))
//    println(getDeviceName(C10("[C10]")))
//
//    //不会要求列举全部
//    var device: POS? = C10("C10")
//    var name: String = ""
//    when (device) {
//        is A8 -> name = "移动终端：" + device.name
//    }
//    println(name)
}

//fun getDeviceName(device: POS) = when (device) {
//    //会要求列举全部
//    is A8 -> "移动终端：" + device.name
//    is C10 -> "收银机：" + device.name
//    is C9 -> "收银机：" + device.name
//}


typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

fun mainTest() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // 输出 "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // 输出 "[1]"
}
