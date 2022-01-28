package com.example.lab1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.MediaStore
import android.provider.SyncStateContract
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doAfterTextChanged
import com.example.lab1.Kalkulator.Companion.c
import java.io.File
import android.view.View as View1


class MainActivity : AppCompatActivity() {
    companion object {
        val list = mutableListOf<String>()
        var a = ""
        var b = ""
        const val START_ACTIVITY_3_REQUEST_CODE = 0
    }

    lateinit var pref: SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        pref = getPreferences(Context.MODE_PRIVATE)

        //zmiana wartości zmiennych a ib czyli numerów
        var_a.doAfterTextChanged { a = var_a.text.toString() }
        var_b.doAfterTextChanged { b = var_b.text.toString() }

        //Wynik kalkulatora{
        var c = intent.getStringExtra("c")
        println(c)
        textView.text = "WYNIK: " + c.toString()
        // }

        //OBRAZEK
        imageView.setImageResource(R.drawable.aa)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this@MainActivity, "kliknięto mnie", Toast.LENGTH_SHORT).show()
                imageView.setImageResource(R.drawable.aa)
            } else {
                imageView.setImageResource(R.drawable.xcv)

            }
        }

        button.setOnClickListener {
            textView.text = editText.text
            Toast.makeText(this@MainActivity, textView.text, Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(this@MainActivity, "wyslano email", Toast.LENGTH_SHORT).show()

        }


        clear.setOnClickListener {
            finish();
            startActivity(intent);
            overridePendingTransition(0, 0);
            getPreferences(Context.MODE_PRIVATE).edit().clear().apply()
            Toast.makeText(applicationContext, R.string.reset, Toast.LENGTH_SHORT).show()
        }
    }

    //Lista śmieci
    fun listOfTrash(view: View1) {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        //      val message = editText.text.toString()
        val intent = Intent(this, ListOfTrash::class.java).apply {
        }
        startActivity(intent)
    }

    //wyszukiwanie w google
    fun googleSearch(view: View1) {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        //      val message = editText.text.toString()
        val intent = Intent(this, GoogleSearch::class.java).apply {
        }
        startActivity(intent)
    }

    //kontakty
    fun Contacts(view: View1) {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        //      val message = editText.text.toString()
        val intent = Intent(this, GetContacts::class.java).apply {
        }
        startActivity(intent)
    }

    //Aparat, robieenie zdjęcia
    val REQUEST_CODE = 200
    fun Camera(view: View1) {

        val intent = Intent(this, CameraAndView::class.java).apply {
        }
        startActivity(intent)
    }

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                println("aa")
                val intent = result.data
                Toast.makeText(applicationContext, "wynik:" + intent, Toast.LENGTH_SHORT).show()
                textView.text = intent.toString()
            }
        }

    //kalkulator
    fun Calc(view: View1) {
        startForResult.launch(Intent(this, Kalkulator::class.java).apply {
            putExtra("var_a", a)
            putExtra("var_b", b)
        })


    }


}





