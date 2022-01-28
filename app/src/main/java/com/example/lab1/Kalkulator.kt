package com.example.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kalkulator.*

class Kalkulator : AppCompatActivity() {
    companion object {
        var c = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        val var_a = intent.getStringExtra("var_a")
        val var_b = intent.getStringExtra("var_b")
        println(var_b)
        var_aa.text = var_a
        var_bb.text = var_b


        radioButtonPlus.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) { val parsedIntA = var_a?.toInt()
                val parsedIntB = var_b?.toInt()
                c = parsedIntA?.plus(parsedIntB!!)!!
                println(c)
                Toast.makeText(this@Kalkulator, c.toString(), Toast.LENGTH_SHORT).show()
                licz.setOnClickListener {
                    send()
                }
            }
        }
        radioButtonMinus.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val parsedIntA = var_a?.toInt()
                val parsedIntB = var_b?.toInt()
                c = parsedIntA?.minus(parsedIntB!!)!!
                println(c)
                Toast.makeText(this@Kalkulator, c.toString(), Toast.LENGTH_SHORT).show()
                licz.setOnClickListener {
                    send()
                }
            }
        }
        radioButtonMultiple.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val parsedIntA = var_a?.toInt()
                val parsedIntB = var_b?.toInt()
                c = parsedIntA?.times(parsedIntB!!)!!
                println(c)
                Toast.makeText(this@Kalkulator, c.toString(), Toast.LENGTH_SHORT).show()
                licz.setOnClickListener {
                    send()
                }
            }
        }


    }


    override fun onBackPressed() {

        super.onBackPressed()
    }

    fun send() {

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("c", c.toString())
        }
        startActivity(intent)
    }


}
