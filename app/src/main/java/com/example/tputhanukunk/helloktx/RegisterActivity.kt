package com.example.tputhanukunk.helloktx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.toast
import com.example.tputhanukunk.helloktx.extension.runActivityForResult
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSubmit.setOnClickListener {
            runActivityForResult<HelloActivity>(HelloActivity.REQUEST_CODE) {
                putExtra(HelloActivity.EXTRA_NAME, etName.text.toString())
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HelloActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            toast(R.string.toast_message)
        }
    }

}


