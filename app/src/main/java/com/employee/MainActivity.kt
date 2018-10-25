package com.employee

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var mEditNameView: EditText? = null
    private var mEditAgeView: EditText? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mEditNameView = findViewById(R.id.name)
        mEditAgeView = findViewById(R.id.age)

        val button = findViewById<Button>(R.id.add_employee)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(mEditNameView!!.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val employeeName = mEditNameView!!.text.toString()
                val employeeage = mEditAgeView!!.text.toString()

                replyIntent.putExtra(EXTRA_NAME, employeeName)
                replyIntent.putExtra(EXTRA_AGE, employeeage)

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {

        val EXTRA_NAME = "name"
        val EXTRA_AGE = "age"

    }
}