package com.my.memory.kotlin

/**
 *
 *
 * @author WangJY
 * create at 2019/4/23
 */

fun main() {
    testInterface()
    testInt()
    field()
    modifier()
    //尾递归求 1+2+3+...+n 的和
    println("tailrec " + sum(100000, 0))

    //println(sum(100000))// 递归调用 会报  java.lang.StackOverflowError
    println(sum(10))
    println(sum2(100000))// 打印 705082704
}

fun testInterface() {
    var c: OnRsultListenerC = OnRsultListenerC()
    c.code = 2
    println("c.code " + c.code)
}

fun testInt() {
    //-127~128
    var a:Int = 1000
    var b:Int = a
    var c:Int? = a
    var d:Int? = a


    println("b===a is " + (b===a))
    println("c===a is " + (c===a))
    println("d===a is " + (d===a))

    println("b==a is " + (b==a))
    println("c==a is " + (c==a))
    println("d==a is " + (d==a))
}
fun field() {
    val finalText = "cannot modify"
    println(finalText)
    // error: Val cannot be reassigned
//    finalText = "change text"
    var editableText = "ori text"
    println(editableText)
    editableText = "change text"
    println(editableText)

    //延迟加载
    lateinit var delayClass : AdultUserFactory
    //只能修饰, 非kotlin基本类型
    //会使用null来对每一个用lateinit修饰的属性做初始化，而基础类型是没有null类型
//    lateinit var delayInt : Int
}

fun modifier() {
    val user: User = AdultUserFactory().makeUser(UserGrade.VIP)
//    user.finalV = 2;
    println("user1:" + user.name + user.password)
    OpenClass().openMethod()
    ChildClass().openMethod()
}

//数据类
data class User(var name: String, var password: String) {
    var grade: UserGrade? = UserGrade.NORMAL
    val finalV: Int = 1

    //空构造函数
    constructor() : this("", "")
}

//抽象类
abstract class UserFactory {
    fun makeUser(grade: UserGrade): User {
        val user: User = initUser(grade.toString() + System.currentTimeMillis())
        user.grade = grade
        user.name = "";
        println(grade.getDescribe())
        return user
    }

    abstract fun initUser(name: String): User
}
//枚举
enum class UserGrade {
    NORMAL, VIP;
    fun getDescribe(): String{
        return if (this.equals(NORMAL)) {
            "普通"
        } else {
            "VIP"
        }
    }
}

//继承抽象类
class AdultUserFactory : UserFactory() {
    //重写方法
    override fun initUser(name: String): User {
        return if (!name?.equals("")) {
            User(name, "123456")
        } else {
            User()
        }
    }
}

//可继承的类
open class OpenClass {
    //如果方法没有open，子类无法重写
    open fun openMethod() {
        println("OpenClass openMethod")
    }
}

//子类
class ChildClass : OpenClass() {
    //重写函数
    override fun openMethod() {
        //super.openMethod()
        println("ChildClass openMethod")
    }
}

tailrec fun sum(n: Int, result: Int = 0): Int {
    if (n == 1) return result + 1
    return sum(n - 1, n + result)
}

fun sum(n: Int): Int {
    if (n == 1) return 1
    return n + sum(n - 1)
}

fun sum2(n: Int): Int {
    var copyN = n
    var result = 0
    while (copyN > 0) {
        result += copyN
        copyN--
    }
    return result
}
