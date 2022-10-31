package com.example.practic_14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class HandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)
        val argument : Bundle? = intent.extras
        var emailText : EditText = findViewById(R.id.emailEditText)
        var nameText : EditText = findViewById(R.id.nameEditText)
        var ageText : EditText = findViewById(R.id.ageEditText)
        if (argument != null) {
            emailText.setText("${argument.get("email").toString()}")
            nameText.setText("${argument.get("name").toString()}")
            ageText.setText("${argument.get("age").toString()}")
        }
    }

    fun onClick_ButtonRespond(view: View) {
        val argument : Bundle? = intent.extras
        var emailText : EditText = findViewById(R.id.emailEditText)
        var nameText : EditText = findViewById(R.id.nameEditText)
        var ageText : EditText = findViewById(R.id.ageEditText)
        val intent : Intent = Intent(this@HandlerActivity, MainActivity::class.java)
        if(emailText.text.isNotEmpty() && nameText.text.isNotEmpty() && ageText.text.isNotEmpty())
        {
            if (argument != null) {
                if(emailText.text.toString() != "${argument.get("email").toString()}") intent.putExtra("email", "${emailText.text.toString()} *")
                else intent.putExtra("email", emailText.text.toString())

                if(nameText.text.toString() != "${argument.get("name").toString()}") intent.putExtra("name", "${nameText.text.toString()} *")
                else intent.putExtra("name", nameText.text.toString())

                if(ageText.text.toString() != "${argument.get("age").toString()}") intent.putExtra("age", "${ageText.text.toString()} *")
                else intent.putExtra("age", ageText.text.toString())




                startActivity(intent)
            }
        }
        else {
            val toast: Toast = Toast.makeText(applicationContext, "Одно или несколько полей пустые!", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}