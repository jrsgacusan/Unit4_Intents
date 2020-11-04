package com.example.intents


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        findViewById<Button>(R.id.btnCamera).setOnClickListener {
            openCamera()
        }
        findViewById<Button>(R.id.btnContacts).setOnClickListener {
//            showContacs()
        }
        findViewById<Button>(R.id.btnMessages).setOnClickListener {

        }
        findViewById<Button>(R.id.btnGallery).setOnClickListener {

        }
        findViewById<Button>(R.id.btnClock).setOnClickListener {

        }
    }
    val REQUEST_IMAGE_CAPTURE = 1
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
    }
//    private fun showContacs() {
//        val uri = Uri.parse("content://contacts/people/*")
//        val showContactsIntent = Intent(Intent.ACTION_DIAL, uri)
//        startActivity(showContactsIntent)
//    }
}