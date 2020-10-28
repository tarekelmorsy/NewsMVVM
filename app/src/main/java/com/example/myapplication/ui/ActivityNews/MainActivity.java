package com.example.myapplication.ui.ActivityNews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Model.AllNews;
import com.example.myapplication.Model.Source;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NewsViewModel newsViewModel;
      NewsAdapter adapter;
    private List<Source>sourceList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.getAll();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        newsViewModel.listMutableLiveData.observe(this, new Observer<AllNews>() {
            @Override
            public void onChanged(AllNews allNews) {
                sourceList=allNews.getSources();
                    adapter = new NewsAdapter(MainActivity.this,sourceList);
                recyclerView.setAdapter(adapter);


            }
        });

    }
}