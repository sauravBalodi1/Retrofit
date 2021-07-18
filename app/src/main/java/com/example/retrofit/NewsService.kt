package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2021-06-18&sortBy=publishedAt&apiKey=API_KEY
const val BASE_URL="https://newsapi.org/"
const val API_KEY="58d785e502cc4021b54f409113e158e8"
interface NewsInteface {
    @GET("v2/top-headlines?apiKey=$API_KEY")
     fun getHeadlines(@Query("country")country:String, @Query("page")page:Int):Call<News>
}
//making singleton Retrofit object
object NewsService{
    val newsInstance: NewsInteface
    init{
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInteface::class.java)
    }


}