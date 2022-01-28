package com.example.lab1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import contacts.core.*

import contacts.core.Fields.Email
import contacts.core.Fields.Name
import contacts.core.entities.Address
import contacts.core.util.*
import kotlinx.android.synthetic.main.activity_get_contacts.*
import java.util.EnumSet.range


class GetContacts : AppCompatActivity() {

    // The ListView
    private val lstNames: ListView? = null

    // Request code for READ_CONTACTS. It can be any number > 0.
    private val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_contacts)
        var name2: String
        var phoneNumber2: String

        search_contact.setOnClickListener {
                val contacts = Contacts(this).query()
                    .where(
                        (Fields.Phone.Number equalTo editTextPhone.text.toString())
                    )
                    .accounts()
                    .find()
                for (i in contacts) {
                    i.toMutableContact()
                    name2 = i.displayNameAlt.toString()
                    var ii = i.toMutableContact()
                    ii.phones()
                    phoneNumber2 = i.phones().toString()
                    area_contacts.text = name2

                }



        }


    }
}

