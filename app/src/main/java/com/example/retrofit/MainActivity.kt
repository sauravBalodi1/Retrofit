package com.example.retrofit

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.security.auth.callback.Callback
import kotlin.coroutines.CoroutineContext

//import com.example.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    //   private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: NewsAdapter
//    private lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        job = Job()
//          GlobalScope.launch(Dispatchers.Main) {
//              getNews()
//          }
        //we are making request in main thread that we shoul.d not do in global scope

        // now we are creating own coroutine scope
        lifecycleScope.launch {
            var new = getNews()
            if (new != null) {
                adapter = NewsAdapter(context = this@MainActivity, new?.articles)
                val recViewKiId = findViewById<RecyclerView>(R.id.Recycleview)
                recViewKiId.adapter = adapter
                recViewKiId.layoutManager = LinearLayoutManager(this@MainActivity)
                Log.d("news is: ", new.toString())
            } else {
                Log.d("else is: ", new.toString())
            }
        }
        //
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        job.cancel()
//    }

    private suspend fun getNews(): News? {
        val response = NewsService.newsInstance.getHeadlines("in", 2)

        return response.body()
//            val new=response.body()
//             if (new != null) {
//                 adapter= NewsAdapter(this,new?.articles)
//                 val recViewKiId=findViewById<RecyclerView>(R.id.Recycleview)
//                 recViewKiId.adapter=adapter
//                 recViewKiId.layoutManager=LinearLayoutManager(this)
//                 Log.d("news is: ",new.toString())
//             }
//       else{
//                 Log.d("else is: ",new.toString())
//             }


//        news.enqueue(object : retrofit2.Callback<News> {
//            override fun onResponse(call: Call<News>, response: Response<News>) {
//                val news = response.body()
//                if (news != null) {
//                    Log.d("ssE: ",news.toString())
//                    adapter= NewsAdapter(this@MainActivity,news.articles)
//                    //now setting adapter
//                    val recViewKiId=findViewById<RecyclerView>(R.id.Recycleview)
//                    recViewKiId.adapter=adapter
//                    recViewKiId.layoutManager=LinearLayoutManager(this@MainActivity)
//                }
//            }
//
//            override fun onFailure(call: Call<News>, t: Throwable) {
//                Log.d("E E", "Error in fetching code", t)
//            }
//        })
    }

//    override val coroutineContext: CoroutineContext
//        get() = job + Dispatchers.Main
//Dispatchers.IO-> network requests or disk read write
//Dispatchers.Main-> Main safety
//Dispatchers.Default-> CPU Intensive Task

}