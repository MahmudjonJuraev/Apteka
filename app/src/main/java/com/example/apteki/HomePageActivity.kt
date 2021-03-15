package com.example.apteki

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_page.*

class HomePageActivity : AppCompatActivity() {

    var visibility:Boolean = true
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        linearLayoutManager = LinearLayoutManager(this)
        get_grugs.layoutManager = linearLayoutManager
        search_drug.setOnClickListener { showHide() }
        dori_search.setOnClickListener { showHide() }
    }

    fun showHide() {
        if (visibility) {

            dori_list.visibility = View.VISIBLE
            search_place.visibility = View.INVISIBLE
            visibility=false

            if (search_drug == null) {
                dori_list.visibility = View.INVISIBLE
            }

        } else {
            dori_list.visibility = View.INVISIBLE
            search_place.visibility = View.VISIBLE
            visibility= true
        }
    }
}