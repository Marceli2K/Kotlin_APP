package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_to_list_of_trash.*
import kotlinx.android.synthetic.main.activity_list_of_trash.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button
import java.io.File

class AddToListOfTrash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_list_of_trash)


        add_new_trash_to_list_button.setOnClickListener {
            MainActivity.Companion.list.add(0,add_new_trash_to_list_input.text.toString())
            ListOfTrash.sizeListOld = MainActivity.list.size
            File(applicationContext.filesDir, "listOfTrash.txt").writeText(MainActivity.Companion.list.toString())
            println("aa"+File(applicationContext.filesDir, "listOfTrash.txt").readLines().toString())
            //onBackPressed()
            Toast.makeText(this@AddToListOfTrash, "Dodano", Toast.LENGTH_SHORT).show()

        }
        anuluj.setOnClickListener {
            onBackPressed()

        }



    }
}

private fun File.addText(s: String) {

}

private fun File.writeLines(toString: String) {

}
