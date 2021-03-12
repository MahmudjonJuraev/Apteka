package com.example.apteki

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_hududni_tanlash.*
import kotlinx.android.synthetic.main.tags_item.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

class ChooseLocationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hududni_tanlash)
        setSupportActionBar(toolbar)

        saveLocations.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        backk.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        tagsRV.layoutManager = linearLayoutManager
        createList()
    }
    fun createList(){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        tagsRV.layoutManager = linearLayoutManager
        val tags = ArrayList<String>()
        tags.add("Toshkent")
        tags.add("Andijon")
        tags.add("Samarqand")
        tags.add("Qashqadaryo")
        tags.add("Jizzax")
        tags.add("Navoiy")
        tags.add("Namangan")
        tags.add("Surxondaryo")
        tags.add("Sirdaryo")
        tags.add("Farg‘ona")
        tags.add("Farg‘ona")
        tags.add("Xorazm")
        tags.add("Qoraqalpog‘iston Respublikasi")
        tags.add("Toshkent viloyati")
        val adapter = TagsAdapter(tags, object : MyOnClickListener{
            override fun onClicked(tag: String) {
                Log.d("TagsListActivity", "tag = " + tag)

            }

        })
        tagsRV.adapter = adapter
    }


}




