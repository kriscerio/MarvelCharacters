package com.kriscerio.marvelcharacters.ui.main

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.data.KEY
import com.kriscerio.marvelcharacters.ui.characterinfo.CharacterActivity
import com.kriscerio.marvelcharacters.ui.main.`object`.MainFeed
import com.kriscerio.marvelcharacters.ui.main.`object`.Result
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

        holder?.result = feeds
    }
}

class ViewHolder (val view : View, var result : Result? = null) : RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            val intent = Intent(view.context,CharacterActivity::class.java)
            intent.putExtra(KEY.HERO_NAME_KEY,result?.name)
            intent.putExtra(KEY.HERO_NAME_DESCRIPTION_KEY,result?.description)
            view.context.startActivity(intent)
        }
    }
}
