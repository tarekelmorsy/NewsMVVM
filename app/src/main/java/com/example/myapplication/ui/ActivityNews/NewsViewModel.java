package com.example.myapplication.ui.ActivityNews;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.AllNews;
import com.example.myapplication.Model2.ArticleRespones;
import com.example.myapplication.data.ClintRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    MutableLiveData<AllNews> listMutableLiveData= new MutableLiveData<>();
     public void getAll(){


        ClintRetrofit.getINSTANCE().getAllnews().enqueue(new Callback<AllNews>() {
            @Override
            public void onResponse(Call <AllNews> call, Response<AllNews> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<AllNews> call, Throwable t) {

            }
        });
    }

}
