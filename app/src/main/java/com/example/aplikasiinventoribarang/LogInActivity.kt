package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    lateinit var handler : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        handler =
            DatabaseHelper(
                this
            )

        tv_sign_up.setOnClickListener {
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        Btn_LogIn.setOnClickListener {
            if (handler.userPresent(ET_Email_LogIn.text.toString(), ET_Password_LogIn.text.toString())) {
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
