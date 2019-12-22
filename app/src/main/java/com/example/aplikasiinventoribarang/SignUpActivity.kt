package com.example.aplikasiinventoribarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var handler : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        handler =
            DatabaseHelper(
                this
            )

        Btn_SignUp.setOnClickListener {
            intent = Intent(this, LogInActivity::class.java)
            handler.insertUser(ET_FullName.text.toString(), ET_Email_SignUp.text.toString(), ET_Password_SignUp.text.toString())
            Toast.makeText(this, "Signup Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
