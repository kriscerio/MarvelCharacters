package com.kriscerio.marvelcharacters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.google.gson.GsonBuilder
import com.kriscerio.marvelcharacters.data.HeroesDataClass
import com.kriscerio.marvelcharacters.ui.main.MainAdapter
import com.kriscerio.marvelcharacters.ui.main.`object`.Data
import com.kriscerio.marvelcharacters.ui.main.`object`.MainFeed
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        FetchCharacterList()
    }

    fun FetchCharacterList() {
        val url = "https://gateway.marvel.com:443/v1/public/characters?ts=9999-12-31&apikey=7f412d2375896165f659472536601234&hash=38cf8499e7b991db3636ffe88eca5a86"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                Log.d("Message",body)

                val gson = GsonBuilder().create()
                val mainFeed = gson.fromJson(body,MainFeed::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(mainFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}
