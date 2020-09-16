package com.example.volleydatafromapi.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleydatafromapi.Adapter.AdapterNews
import com.example.volleydatafromapi.Models.Article
import com.example.volleydatafromapi.Models.NewsResult
import com.example.volleydatafromapi.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mList: ArrayList<Article> = ArrayList()
    var adapterNews: AdapterNews? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        getData()
        adapterNews = AdapterNews(this,mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterNews
    }

    private fun getData() {
        var url = "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=36a3d3a1d7cb428aba2bc96593195ffc"
        var requestQueue = Volley.newRequestQueue(this)
        var request = StringRequest(
                Request.Method.GET,
                url,
                {
                    var gson = Gson()
                    var newsResult = gson.fromJson(it, NewsResult::class.java)
                    mList.addAll(newsResult.articles)
                    adapterNews?.setData(mList)
                },
                {

                }
        )
        requestQueue.add(request)
    }
}