package com.example.lab1

import java.io.File
import java.io.InputStream
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_list_of_trash.*
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Environment
import java.io.BufferedReader


class ListOfTrash : AppCompatActivity() {
    companion object {
        var sizeListOld = MainActivity.list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_trash)
        val sizeListNew = MainActivity.list.size

        // initialize an array adapter
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, MainActivity.list
        )


        // attach the array adapter with list view
        trash_list.adapter = adapter


        // list view item click listener
        trash_list.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = parent.getItemAtPosition(position)
                textViewResult.text = "Selected : $selectedItem"
                rem_trash_button.setOnClickListener {
                    Toast.makeText(this@ListOfTrash, "aaa", Toast.LENGTH_SHORT).show()
                    MainActivity.list.removeFirst()
                    File(applicationContext.filesDir, "listOfTrash.txt").writeText(MainActivity.Companion.list.toString())
                    println(MainActivity.list)
                    adapter.notifyDataSetChanged()
                }
            }
        loadFromFile.setOnClickListener {
            MainActivity.Companion.list.add(File(applicationContext.filesDir, "listOfTrash.txt").readLines().toString())
        }

    }
    override fun onBackPressed() {
        super.onResume()
        recreate()
    }
    fun addToListOfTrash(view: View) {

//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        //      val message = editText.text.toString()
        val intent = Intent(this, AddToListOfTrash::class.java).apply {
        }
        startActivity(intent)

    }


}

fun File.bufferedWriter(charset: String) {

}

private fun String.use(block: (String) -> Boolean) {

}
