package com.example.retrofit

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

//import com.example.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //   private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in", 2)
        news.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("ssE: ",news.toString())
                    adapter= NewsAdapter(this@MainActivity,news.articles)
                    //now setting adapter
                    val recViewKiId=findViewById<RecyclerView>(R.id.Recycleview)
                    recViewKiId.adapter=adapter
                    recViewKiId.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("E E", "Error in fetching code", t)
            }
        })
    }


}