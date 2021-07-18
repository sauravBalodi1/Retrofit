package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class My_Adapter(val songs:List<Song>): RecyclerView.Adapter<My_Adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.txtTitle.text=songs[position].title
        holder.txtDescription.text=songs[position].description

    }

    override fun getItemCount(): Int {
       return songs.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtTitle = itemView.findViewById<TextView>(R.id.textView)
        var txtDescription = itemView.findViewById<TextView>(R.id.textView2)
    }
}

//class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//    var txtTitle=itemView.findViewById<TextView>(R.id.textView)
//    var txtDescription=itemView.findViewById<TextView>(R.id.textView2)
//
//}making this class as nested