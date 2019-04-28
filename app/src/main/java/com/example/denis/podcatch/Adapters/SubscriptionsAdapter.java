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

import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SubscriptionsAdapter extends RecyclerView.Adapter<SubscriptionsAdapter.SubscriptionViewHolder>{
    private Context context;
    private ArrayList<Podcast> podcasts;
    final private  ItemClickListener itemClickListener;

    public SubscriptionsAdapter(Context context, ItemClickListener listener) {
        this.context = context;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.subscription, parent, false);
        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        final Podcast podcast = podcasts.get(holder.getAdapterPosition());
        Picasso.with(context)
                .load(podcast.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.poster);

        holder.podcast_name.setText(podcast.getTitle());
    }

    @Override
    public int getItemCount() {
        if (podcasts != null) {
            return podcasts.size();
        }
        return 0;
    }


    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
        notifyDataSetChanged();
    }
    public interface ItemClickListener{
        void onItemClickListener(Podcast podcast);
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView poster;
        TextView podcast_name;
        public SubscriptionViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.podcast_poster);
            podcast_name = itemView.findViewById(R.id.tv_podcast_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClickListener(podcasts.get(getAdapterPosition()));
        }
    }
}
