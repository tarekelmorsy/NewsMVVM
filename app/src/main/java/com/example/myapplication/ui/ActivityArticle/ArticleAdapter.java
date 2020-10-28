package com.example.myapplication.ui.ActivityArticle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model2.Article;
import com.example.myapplication.R;
import com.example.myapplication.ui.WebActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewholder> {

    private Context context;
    private List<Article> articleList;


    public ArticleAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
     }
    @NonNull
     @Override
    public ArticleViewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ArticleViewholder(LayoutInflater.from(context).inflate(R.layout.article_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(  ArticleAdapter.ArticleViewholder holder, int position) {
          Article cuurentarticle=articleList.get(position);
        holder.txttitle.setText(cuurentarticle.getTitle());
        Picasso.get().load(cuurentarticle.getUrlToImage()).into(holder.imggg);
        holder.txtarthure.setText(cuurentarticle.getAuthor());
        holder.txtdat.setText(cuurentarticle.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, WebActivity.class);
                i.putExtra("url",cuurentarticle.getUrl());
                context.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public class ArticleViewholder extends RecyclerView.ViewHolder {
        TextView txttitle,txtarthure,txtdat;
        ImageView imggg;

        public ArticleViewholder(@NonNull View itemView) {
            super(itemView);
            txttitle=itemView.findViewById(R.id.txt_title);
            imggg=itemView.findViewById(R.id.img_res);
            txtdat=itemView.findViewById(R.id.date);
            txtarthure=itemView.findViewById(R.id.txtarthu);
        }

}}
