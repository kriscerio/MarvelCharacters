package com.kriscerio.marvelcharacters.ui.characterinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.kriscerio.marvelcharacters.R
import com.kriscerio.marvelcharacters.data.KEY
import com.kriscerio.marvelcharacters.ui.main.`object`.MainFeed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class CharacterActivity : AppCompatActivity() {

    var collapsingToolbarLayout : CollapsingToolbarLayout?=null
    lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        init()

        val navBarTitle = intent.getStringExtra(KEY.HERO_NAME_KEY)
        supportActionBar?.title = navBarTitle

        //getIntent from main
        val tvHeroDescription = intent.getStringExtra(KEY.HERO_NAME_DESCRIPTION_KEY)
//        tv_hero_description.setText(tvHeroDescription)
        if (tvHeroDescription.isEmpty()) {
            tv_hero_description.setText(R.string.string_no_description)
        }else {
            tv_hero_description.setText(tvHeroDescription)
        }

        val jpg : String = ".jpg"
        val ivHeroImage = intent.getStringExtra(KEY.HERO_IMAGE_KEY)
        val imageURL : String = "$ivHeroImage$jpg"
        Picasso.get().load(imageURL).into(iv_hero_image)

        FetchCharacterInfo()
    }

    fun init() {
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbarLayout = findViewById(R.id.collapsingToolBar)


    }

    fun FetchCharacterInfo() {
        val url = "https://gateway.marvel.com:443/v1/public/characters?ts=9999-12-31&apikey=7f412d2375896165f659472536601234&hash=38cf8499e7b991db3636ffe88eca5a86"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                Log.d("Message::::",body)

                val gson = GsonBuilder().create()
                val mainFeed = gson.fromJson(body, MainFeed::class.java)

//                runOnUiThread {
//                    recyclerView_main.adapter = MainAdapter(mainFeed)
//                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}
