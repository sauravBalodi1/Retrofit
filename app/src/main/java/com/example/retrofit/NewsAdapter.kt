package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context,val articles:List<Article>): Adapter<NewsAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //her we will store our views
        var newsImage=itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription=itemView.findViewById<TextView>(R.id.newsDescription)
        var authorDescription=itemView.findViewById<TextView>(R.id.authorId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       val view =LayoutInflater.from(context).inflate(R.layout.item_retrofit_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description
        holder.authorDescription.text=article.author
        //we can bind image like this ,so here is the way learn it
     Glide.with(context).load(article.urlToImage).into(holder.newsImage)
        //setting button property
        holder.newsImage.setOnClickListener{
            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}