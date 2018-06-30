package com.example.tputhanukunk.helloktx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.toast
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSubmit.setOnClickListener {
            val intent = Intent(this, HelloActivity::class.java)
            intent.putExtra(HelloActivity.EXTRA_NAME, etName.text.toString())
            startActivityForResult(intent, HelloActivity.REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HelloActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            toast(R.string.toast_message)
        }
    }

}


