package com.dcom.triviamultilenguaje.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dcom.triviamultilenguaje.R
import com.dcom.triviamultilenguaje.activities.questions.MainActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val user = findViewById<EditText>(R.id.user)
        val username = user.text
        val resultCorrect: Int = 0

        buttonLogin.setOnClickListener(){
            if(user.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intentbutton = Intent(this,MainActivity::class.java).apply {
                    putExtra("log",username.toString())
                    putExtra("Result",resultCorrect.toString().toInt())
                }
                startActivity(intentbutton)
            }


        }
    }
}

