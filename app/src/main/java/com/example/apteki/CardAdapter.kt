package com.example.apteki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CardAdapter(private val tags: ArrayList<String>): RecyclerView.Adapter<CardAdapter.MyCardViewHolder>() {

    inner class MyCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameOfPharmacy: TextView = view.findViewById<View>(R.id.NameOfPharmacy) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MyCardViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.tags_item, parent, false)
        return MyCardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:  MyCardViewHolder, position: Int) {
        val tag = tags[position]
        holder.nameOfPharmacy.text = tag
        holder.nameOfPharmacy.setOnClickListener {

        }
    }


    override fun getItemCount(): Int {
        return tags.size
    }


}
