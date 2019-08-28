package com.my.memory.kotlin

import kotlin.properties.Delegates


interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class UserD {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

class Derived(b: Base) : Base by b

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
    println(lazyValue)
    println(lazyValue)
}