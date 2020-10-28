package com.example.myapplication.ui.ActivityArticle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Model2.ArticleRespones;
import com.example.myapplication.R;

public class ArticlesActivity extends AppCompatActivity {
    ArticleViewModel articleViewModel;
RecyclerView recyclerView;
    private ArticleAdapter adapter;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

        String domain=getIntent().getStringExtra("domain");

        articleViewModel.getAllArticlesFromSource(domain);
        recyclerView=findViewById(R.id.rv_article);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        articleViewModel.articleResponesMutableLiveData.observe(this, new Observer<ArticleRespones>() {
            @Override
            public void onChanged(ArticleRespones articleRespones) {
                adapter=new ArticleAdapter(ArticlesActivity.this,articleRespones.getArticles());
                recyclerView.setAdapter(adapter);

            }
        });
    }
}