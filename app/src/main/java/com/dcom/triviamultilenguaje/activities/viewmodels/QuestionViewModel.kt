package com.dcom.triviamultilenguaje.activities.viewmodels

import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {
   var result: Int = 0

    fun changeResult(number: Int){
        result+= number
    }

}