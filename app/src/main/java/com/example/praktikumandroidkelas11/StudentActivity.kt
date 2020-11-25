package com.example.praktikumandroidkelas11

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val etIdStudent = findViewById<EditText>(R.id.etIdStudent)
        val etNameStudent = findViewById<EditText>(R.id.etNameStudent)
        val etPhoneNumberStudent = findViewById<EditText>(R.id.etPhoneNumberStudent)
        val btSave = findViewById<Button>(R.id.btSaveStudent)
        val btDial = findViewById<Button>(R.id.btDialStudent)

        btSave.setOnClickListener {

            val id = etIdStudent.text.toString()
            val name = etNameStudent.text.toString()
            val phoneNumber = etPhoneNumberStudent.text.toString()

            val student = Student(id,name,phoneNumber)

            val i = Intent(this, ResultActivity::class.java)
//            i.putExtra(ResultActivity.EXTRA_ID,id)
//            i.putExtra(ResultActivity.EXTRA_NAME,name)
//            i.putExtra(ResultActivity.EXTRA_PHONE_NUMBER,phoneNumber)

            i.putExtra(ResultActivity.EXTRA_STUDENT, student)

            startActivity(i)

            //POJO (Plain Old Java Object)
            //Test
        }

        btDial.setOnClickListener {
            val phoneNumber = etPhoneNumberStudent.text.toString()
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.change_language_settings){
            val i = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}