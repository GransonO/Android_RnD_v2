package com.granson.seniordeveloper.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

object Utilities {

    fun Activity.openActivity(context: Context, className: Class<*>) {
        val intent = Intent(context, className)
        context.startActivity(intent)
        finish()
    }

    fun List<Any>.listInt(): Int{
        return size
    }
}