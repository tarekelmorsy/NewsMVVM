package com.example.myapplication.data;

import com.example.myapplication.Model.AllNews;
import com.example.myapplication.Model2.ArticleRespones;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClintRetrofit {

    private static final String URL= "https://newsapi.org/v2/";
    private static   ClintRetrofit INSTANCE ;
    private InterfaceNews interfaceNews;
    private final String key="23ba2d485967445e829ec6a90b645699";

    public ClintRetrofit() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        interfaceNews = retrofit.create(InterfaceNews.class);
    }
    public static ClintRetrofit getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new ClintRetrofit();
        }
        return INSTANCE;
    }
    public Call<AllNews> getAllnews(){
        return interfaceNews.getAllnews(key);
    }

    public Call<ArticleRespones> getAllArticlesFromSource(String id){

return interfaceNews.getAllArticlesFromSource(id,key);
    }

}
