package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        findViewById<Button>(R.id.btnLogIn).setOnClickListener {
            val usernameText = findViewById<View>(R.id.txtUsername) as EditText
            val username = usernameText.text.toString();

            val passwordText = findViewById<View>(R.id.txtPassword) as EditText
            val password = passwordText.text.toString();

            if (username.equals("admin") && password.equals("password")) { //Checks if the credentials are correct, if correct, go to other activity. (No DB yet)
                goToOtherActivity()
                Toast.makeText(this, "You are now logged in.", Toast.LENGTH_SHORT).show()
            } else if (username != "admin" || password != "password") {
                Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Function to go to the next activity
    private fun goToOtherActivity() {
        val intent = Intent( this, OtherActivity::class.java )
        startActivity(intent)
    }


}

