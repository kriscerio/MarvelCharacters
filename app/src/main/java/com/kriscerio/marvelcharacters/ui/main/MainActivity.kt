package com.kriscerio.marvelcharacters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.kriscerio.marvelcharacters.data.HeroesDataClass
import com.kriscerio.marvelcharacters.ui.main.MainAdapter
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val hero = ArrayList<HeroesDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val adapter = MainAdapter(this@MainActivity,hero)
        recyclerView.adapter = adapter

        HeroesList()
    }

    fun HeroesList(){

   //     val url = "https://gateway.marvel.com:443/v1/public/characters?apikey=1e41e418afbcb509a8f42546edfab602360351c4"
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onResponse(call: Call?, response: Response?) {
//                val body = response?.body()?.string()
//                println(body)
//            }
//
//            override fun onFailure(call: Call?, e: IOException?) {
//                println("Failed to execute request")
//            }
//        })

        val hero_description : String = getString(R.string.lorem_ipsum)
        hero.add(HeroesDataClass("Captain America", hero_description+""))
        hero.add(HeroesDataClass("Iron Man", hero_description+""))
        hero.add(HeroesDataClass("Hulk", hero_description+""))
        hero.add(HeroesDataClass("Scarlet Witch", hero_description+""))
        hero.add(HeroesDataClass("Vision", hero_description+""))
        hero.add(HeroesDataClass("Thor", hero_description+""))
        hero.add(HeroesDataClass("Spider Man", hero_description+""))
        hero.add(HeroesDataClass("Doctor Strange", hero_description+""))
        hero.add(HeroesDataClass("Hawk Eye", hero_description+""))
        hero.add(HeroesDataClass("War Machine", hero_description+""))
        hero.add(HeroesDataClass("Ant Man", hero_description+""))
        hero.add(HeroesDataClass("Wasp", hero_description+""))
        hero.add(HeroesDataClass("Black Panther", hero_description+""))
        hero.add(HeroesDataClass("Black Widow", hero_description+""))
        hero.add(HeroesDataClass("QuickSilver", hero_description+""))
    }
}