package com.example.denis.podcatch.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.PodcastDetailActivity;
import com.example.denis.podcatch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PodcastCategoryAdapter extends RecyclerView.Adapter<PodcastCategoryAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Podcast> podcasts;

    public PodcastCategoryAdapter(Context context, ArrayList<Podcast> podcasts) {
        this.context = context;
        this.podcasts = podcasts;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.podcast, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final Podcast podcast = podcasts.get(holder.getAdapterPosition());
        Picasso.with(context)
                .load(podcast.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.podcast_poster);
        holder.title.setText(podcast.getTitle());

        holder.podcast_poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PodcastDetailActivity.class);
                intent.putExtra("podcast_id", podcast.getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return podcasts.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView podcast_poster;
        TextView title;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            podcast_poster = itemView.findViewById(R.id.podcast_pic);
            title = itemView.findViewById(R.id.podcast_title);
        }
    }
}
