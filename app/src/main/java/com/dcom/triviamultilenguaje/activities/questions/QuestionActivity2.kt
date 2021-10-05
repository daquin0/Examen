package com.dcom.triviamultilenguaje.activities.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dcom.triviamultilenguaje.R
import com.dcom.triviamultilenguaje.activities.viewmodels.QuestionViewModel
import com.dcom.triviamultilenguaje.databinding.ActivityMainBinding
import com.dcom.triviamultilenguaje.databinding.ActivityQuestion2Binding

class QuestionActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityQuestion2Binding
    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        val binding = DataBindingUtil.setContentView<ActivityQuestion2Binding>(this,R.layout.activity_question2)
        val bundle: Bundle? = intent.extras
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        val button_A1 = findViewById<Button>(R.id.q2_answer1)
        val button_A2 = findViewById<Button>(R.id.q2_answer2)
        val button_A3 = findViewById<Button>(R.id.q2_answer3)

            if(bundle!= null) {
                val myData: String = bundle.getString("log") ?: "NADA"
                var resData: Int = bundle.getInt("Result") ?: 0
                button_A1.setOnClickListener() {
                    val intentButtonA1 = Intent(this, QuestionActivity3::class.java).apply {
                        putExtra("log", myData)

                        putExtra("Result", resData)
                    }

                    startActivity(intentButtonA1)
                }

                button_A2.setOnClickListener() {
                    val intentButtonA2 = Intent(this, QuestionActivity3::class.java).apply {
                        putExtra("log", myData)
                        putExtra("Result", resData)

                    }
                    startActivity(intentButtonA2)
                }


                button_A3.setOnClickListener(){
                    val intentButtonA3= Intent(this,QuestionActivity3::class.java).apply {
                        putExtra("log",myData)
                        resData+=1
                        putExtra("Result", resData)
                    }
                    startActivity(intentButtonA3)
                }
            }
        }
            override fun onBackPressed() {
                moveTaskToBack(true)
            }
    }
