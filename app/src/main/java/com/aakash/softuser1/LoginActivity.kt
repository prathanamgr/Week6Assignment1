package com.aakash.softuser1

import android.content.Intent
import android.opengl.ETC1.isValid
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignIn = findViewById(R.id.btnSignIn)

        btnSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnSignIn.id -> {
                if (ifValidate()) {
                    if (etUsername.text.toString() == "admin" && etPassword.text.toString() == "admin") {
                        Intent(this, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    } else {
                        Toast.makeText(applicationContext, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    private fun ifValidate(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(etUsername.text)) {
            etUsername.error = "Please enter username!"
            etUsername.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(etPassword.text)) {
            etPassword.error = "Please enter password!"
            etPassword.requestFocus()
            flag = false
        }
        return flag
    }
}