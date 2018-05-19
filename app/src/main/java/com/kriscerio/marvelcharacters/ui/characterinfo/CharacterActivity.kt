package com.kriscerio.marvelcharacters.ui.characterinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.ui.main.MainAdapter

class CharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val heroName = intent.getStringExtra(MainAdapter.ViewHolder.HERO_NAME_KEY)
        val heroDescription = intent.getStringExtra(MainAdapter.ViewHolder.HERO_NAME_DESCRIPTION_KEY)

        var tvHeroName = findViewById<TextView>(R.id.tv_hero_name)
        var tvHeroDescription = findViewById<TextView>(R.id.tv_hero_description)
//
        tvHeroName.setText(heroName)
        tvHeroDescription.setText(heroDescription)
//        println("HERO NAME : "+heroName)
//        println("HERO DESCRIPTION : "+heroDescription)
    }
}
