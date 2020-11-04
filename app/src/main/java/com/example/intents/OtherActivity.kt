package com.example.intents


import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        findViewById<Button>(R.id.btnCamera).setOnClickListener { openCamera() }
        findViewById<Button>(R.id.btnContacts).setOnClickListener { showContacs() }
        findViewById<Button>(R.id.btnMessage).setOnClickListener { createMessage() }


    }
    //Handles the function for the Camera button
    val REQUEST_IMAGE_CAPTURE = 1
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
    }
    //Handles the show contacts function
    val REQUEST_SELECT_CONTACT = 1
    fun showContacs() {
        val intent = Intent(Intent.ACTION_PICK).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT)
        }
    }
    //Handles the function for create message button
    fun createMessage() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivity(intent)
    }

}