package com.example.myapplication.data;

import com.example.myapplication.Model.AllNews;
import com.example.myapplication.Model2.ArticleRespones;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface InterfaceNews {

    @GET("sources")
    Call<AllNews> getAllnews(@Query("apiKey")String apikey);
    @GET("top-headlines")
    Call<ArticleRespones> getAllArticlesFromSource(@Query("sources") String sourceId,
                                                   @Query("apiKey") String apiKey);

}
