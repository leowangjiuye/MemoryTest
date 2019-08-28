package com.my.memory.annotation.android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntRange
import android.support.annotation.LayoutRes
import android.support.annotation.Size
import com.my.memory.test.R

class AnnotationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayout(R.layout.activity_annotation)
        size("123")
        range(12)
    }

    private fun setLayout(@LayoutRes res: Int) {
        setContentView(res)
    }


    fun size(@Size(min = 1, max = 2) str: String) {
        println("str $str")
    }

    fun range(@IntRange(from = 1, to = 10) count: Int) {
        println("count $count")
    }
}
