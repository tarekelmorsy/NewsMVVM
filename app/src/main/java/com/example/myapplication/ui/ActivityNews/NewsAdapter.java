package com.example.myapplication.ui.ActivityNews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Source;
import com.example.myapplication.R;
import com.example.myapplication.ui.ActivityArticle.ArticlesActivity;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
     private Context context;
    private List<Source>newsList;

    public NewsAdapter(Context context, List<Source> sourceList) {
        this.context = context;
        this.newsList = sourceList;
     }


    @NonNull
     @Override
    public NewsViewHolder onCreateViewHolder(  ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row_item, parent, false));

    }

    @Override
    public void onBindViewHolder(  NewsAdapter.NewsViewHolder holder, int position) {
         holder.txtnews.setText(newsList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, ArticlesActivity.class);
                i.putExtra("domain",newsList.get(position).getId());
                context.startActivity(i);
            }
        });}


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
         TextView txtnews;
        public NewsViewHolder(  View itemView) {
            super(itemView);

            txtnews=itemView.findViewById(R.id.txtnews);
        }
    }

}
