package com.example.tputhanukunk.helloktx.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle

inline fun <reified T : Activity> Activity.runActivityForResult(requestCode: Int, options: Bundle? = null, intentBuilder: (Intent.() -> Unit) = {}) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && options != null) {
        startActivityForResult(Intent(this, T::class.java).apply(intentBuilder), requestCode, options)
    } else {
        startActivityForResult(Intent(this, T::class.java).apply(intentBuilder), requestCode)
    }
}

inline fun <reified T : Activity> Context.runActivity(options: Bundle? = null, intentBuilder: (Intent.() -> Unit) = {}) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && options != null) {
        startActivity(Intent(this, T::class.java).apply(intentBuilder), options)
    } else {
        startActivity(Intent(this, T::class.java).apply(intentBuilder))
    }
}
