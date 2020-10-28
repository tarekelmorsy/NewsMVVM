package com.example.myapplication.ui.ActivityArticle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model2.ArticleRespones;
import com.example.myapplication.data.ClintRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {
    MutableLiveData<ArticleRespones> articleResponesMutableLiveData = new MutableLiveData<>();
    public void getAllArticlesFromSource(String id){

        ClintRetrofit.getINSTANCE().getAllArticlesFromSource(id).enqueue(new Callback<ArticleRespones>() {
            @Override
            public void onResponse(Call<ArticleRespones> call, Response<ArticleRespones> response) {
                articleResponesMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArticleRespones> call, Throwable t) {

            }
        });
    }
}
