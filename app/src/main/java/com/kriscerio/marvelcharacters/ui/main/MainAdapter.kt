package com.kriscerio.marvelcharacters.ui.main

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.ui.main.`object`.MainFeed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row_main.view.*



class MainAdapter (val mainFeed : MainFeed): RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context).inflate(R.layout.item_row_main,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return mainFeed.data.results.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feeds = mainFeed.data.results.get(position)
        val jpg : String = ".jpg"
        val path : String = feeds.thumbnail.path
        val imageURL : String = "$path$jpg"

        holder?.itemView?.tv_hero_name?.text = feeds.name
        holder?.itemView?.tv_hero_description?.text = feeds.description
        if (holder.itemView.tv_hero_description.text.isEmpty()) {
            holder.itemView.tv_hero_description.setText(R.string.string_no_description)
        }
        val heroImage = holder?.itemView?.iv_hero_image
        Picasso.get().load(imageURL).into(heroImage)
        Log.d("imageURL: ",imageURL)
    }

}

class ViewHolder (view : View) : RecyclerView.ViewHolder(view){

}