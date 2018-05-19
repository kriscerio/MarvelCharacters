package com.kriscerio.marvelcharacters.ui.main

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.data.HeroesDataClass
import com.kriscerio.marvelcharacters.ui.characterinfo.CharacterActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter (val heroList : ArrayList<HeroesDataClass>) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_row_main,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero : HeroesDataClass = heroList[position]
        //holder.civHeroImage.background = hero.image
        holder.tvHeroName.text = hero.hero
        holder.tvHeroDescription.text = hero.description
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        //val civHeroImage = itemView.findViewById(R.id.civ_hero_image) as CircleImageView
        val tvHeroName = itemView.findViewById(R.id.tv_hero_name) as TextView
        val tvHeroDescription = itemView.findViewById(R.id.tv_hero_description) as TextView
        val layout = itemView.findViewById(R.id.ll_hero_info) as LinearLayout

        companion object {
            const val HERO_NAME_KEY = "HERO_NAME"
            const val HERO_NAME_DESCRIPTION_KEY = "HERO_DESCRIPTION"
        }

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context,CharacterActivity::class.java)
                intent.putExtra(HERO_NAME_KEY,""+tvHeroName)
                intent.putExtra(HERO_NAME_DESCRIPTION_KEY,""+tvHeroDescription)
                itemView.context.startActivity(intent)

            }
        }
    }

}