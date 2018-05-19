package com.kriscerio.marvelcharacters.ui.characterinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.data.KEY
import com.kriscerio.marvelcharacters.ui.main.MainAdapter

class CharacterActivity : AppCompatActivity() {

    var collapsingToolbarLayout : CollapsingToolbarLayout?=null
    lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolBar)
//        if (supportActionBar != null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        }


        val heroName = intent.getStringExtra(KEY.HERO_NAME_KEY)
        val heroDescription = intent.getStringExtra(KEY.HERO_NAME_DESCRIPTION_KEY)

        val tvHeroName = findViewById<TextView>(R.id.tv_hero_name)
        val tvHeroDescription = findViewById<TextView>(R.id.tv_hero_description)
//
        tvHeroName.setText(heroName)
        tvHeroDescription.setText(heroDescription)
//        println("HERO NAME : "+heroName)
//        println("HERO DESCRIPTION : "+heroDescription)


    }
}
