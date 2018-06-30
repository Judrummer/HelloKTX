package com.example.tputhanukunk.helloktx

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.*
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        const val REQUEST_CODE = 100
    }

    val name by lazy { intent?.getStringExtra(EXTRA_NAME) ?: "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        val spannable = buildSpannedString {

            color(Color.BLACK) { italic { append("Welcome") } }

            appendln()

            color(Color.BLACK) { bold { underline { append(name) } } }

            appendln()

            color(Color.BLACK) { italic { append("To") } }

            appendln()
            appendln()

            color(Color.RED) { append("Google") }

            appendln()

            color(Color.WHITE) { append("I/O") }

            appendln()

            color(Color.BLUE) { append("Extend") }

            appendln()

            color(Color.WHITE) { append("Bangkok") }

            appendln()

            color(Color.RED) { append("2018") }
        }

        tvHelloMessage.text = spannable

        btnOk.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}
