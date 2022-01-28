package com.example.lab1

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class GoogleSearch : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var btnSearch: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_search)
        title = "KotlinApp"
        editText = findViewById(R.id.editText)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            val term = editText.text.toString()
            intent.putExtra(SearchManager.QUERY, term)
            startActivity(intent)
    }
}}