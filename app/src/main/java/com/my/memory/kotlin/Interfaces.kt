package com.my.memory.kotlin

/**
 *
 *
 * @author WangJY
 * create at 2019/5/13
 */

interface OnResultListener {
    var code: Int
    val message: String

    fun onSuccess(result: String)
    fun onError() {
    }
}
interface ChildListener: OnResultListener {
    fun childResult()
    fun childResultError() {
    }
}

class ChildListenerC: ChildListener {
    override var code: Int
        get() = code
        set(value) {}
    override val message: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onSuccess(result: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun childResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class OnRsultListenerC: OnResultListener {
    override var code: Int = 1

    override val message: String
        get() = "message" //To change initializer of created properties use File | Settings | File Templates.

    override fun onSuccess(result: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun onError() {
//        super.onError()
//    }
}


interface OnResultListener_1 {
    fun onSuccess(result: String)
    fun onError() {
    }
}

class TEST_MULTI: OnResultListener, OnResultListener_1 {
    override var code: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override val message: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onSuccess(result: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface EasyInterface {
    fun easy(result: String)
}