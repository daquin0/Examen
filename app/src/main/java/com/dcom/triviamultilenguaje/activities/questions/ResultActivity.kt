package com.dcom.triviamultilenguaje.activities.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dcom.triviamultilenguaje.R
import com.dcom.triviamultilenguaje.activities.viewmodels.QuestionViewModel
import com.dcom.triviamultilenguaje.databinding.ActivityQuestion3Binding
import com.dcom.triviamultilenguaje.databinding.ActivityResultBinding
import android.util.Log.i as i1

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val button_return = findViewById<Button>(R.id.play_again)

        val bundle: Bundle? = intent.extras
        val binding = DataBindingUtil.setContentView<ActivityResultBinding>(this,R.layout.activity_result)
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        if(bundle!= null) {
            val myData: String = bundle.getString("log") ?: "NADA"
            var resData: Int = bundle.getInt("Result") ?: 0
            binding.username.text = myData
            binding.result.text = "You got ${resData.toString()},out of 3"

            button_return.setOnClickListener(){
                finish()
                val intentButton = Intent(this,MainActivity::class.java).apply {
                    putExtra("log",myData)
                    Log.i("log","hola")
                }
                startActivity(intentButton)
            }

        }

    }
    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}