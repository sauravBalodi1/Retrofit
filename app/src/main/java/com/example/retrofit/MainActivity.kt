package com.example.retrofit

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

//import com.example.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//   private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val id=findViewById<RecyclerView>(R.id.Recycleview)

    val songs= listOf("Hello","sads","ddd","ffff","ggg")
    val songsObjects= mutableListOf<Song>()
    songsObjects.add(Song("hi","9"))
    songsObjects.add(Song("hi","8"))
    songsObjects.add(Song("hi","7"))
    songsObjects.add(Song("hi","6"))
    songsObjects.add(Song("hi","5"))

    id.adapter=My_Adapter(songsObjects)
    id.layoutManager=LinearLayoutManager(this)


    }





}