package com.my.memory.classandobj

import com.my.memory.kotlin.EasyInterface

//From EnumJ
//internal enum class DeviceJ private constructor(private val device: String) {
//    A8("A8-J"),
//    C10("C10-J"),
//
//}

//有class关键字
enum class Device {
    A8,
    C10
}

enum class DeviceStr(val device: String): EasyInterface {
    A8("A8-STR") {
        override fun easy(result: String) {
            println("A8-STR $result")
        }

        override fun printDevice() {
            println(device)
        }
    },
    C10("C10-STR") {
        override fun easy(result: String) {
            println("C10-STR $result")
        }

        override fun printDevice() {
            println(device)
        }
    };//此处需要添加;

    abstract fun printDevice()
}

fun main() {
    println("----JAVA----")
    EnumJ.DeviceJ.A8.easy("JAVA")
    EnumJ.DeviceJ.C10.easy("JAVA")
    println(EnumJ.DeviceJ.A8)
    println(EnumJ.DeviceJ.C10)
    println("--------")
    EnumJ.DeviceWithAbstractMethod.A8.printDevice()
    EnumJ.DeviceWithAbstractMethod.C10.printDevice()

    println("----Kotlin----")
    println("${Device.A8} ${Device.A8.ordinal} ${Device.A8.name}")
    println("${Device.C10} ${Device.C10.ordinal} ${Device.C10.name}")
    println("--------")
    println("${DeviceStr.A8} ${DeviceStr.A8.ordinal} ${DeviceStr.A8.name} ${DeviceStr.A8.device}")
    DeviceStr.A8.printDevice()
    DeviceStr.A8.easy("easy")
    println("${DeviceStr.C10} ${DeviceStr.C10.ordinal} ${DeviceStr.C10.name} ${DeviceStr.C10.device}")
    DeviceStr.C10.printDevice()
    DeviceStr.C10.easy("easy")

//    var device: Device = Device.A8
//    when(device) {
//        Device.A8 -> ""
//    }
}
