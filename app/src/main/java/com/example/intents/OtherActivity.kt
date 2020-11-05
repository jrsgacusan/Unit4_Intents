package com.example.intents


import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        findViewById<Button>(R.id.btnFilestorage).setOnClickListener { selectImage() }
        findViewById<Button>(R.id.btnMessage).setOnClickListener { openMessages() }
        findViewById<Button>(R.id.btnWifi).setOnClickListener { openWifi() }
        findViewById<Button>(R.id.btnTimer).setOnClickListener { showTimer() } //Fail intentionally
        findViewById<Button>(R.id.btnSettings).setOnClickListener { openSettings() } //Fail intentionally
    }
    //Handles the function for btnFilestorage
    val REQUEST_IMAGE_GET = 1
    fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }
    //Handles the show contacts function
    private fun openWifi() {
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    //Handles the function for create message button
    fun openMessages() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivity(intent)
    }
    //The next two functions will fails intentionally
    fun showTimer() {
        val intent = Intent(AlarmClock.ACTION_SHOW_TIMERS)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING) //Alarm clock is not in the category of CATEGORY_APP_MESSAGING
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open TIMER, because the intent category is incorrect.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun openSettings() {
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addCategory(Intent.ACTION_ALL_APPS) //The intent failed because it is not present in the category of ACTION_ALL_APPS
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open SETTINGS.", Toast.LENGTH_SHORT).show()
        }
    }

}