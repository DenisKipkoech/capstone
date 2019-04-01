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
import com.example.denis.podcatch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SubscriptionsAdapter extends RecyclerView.Adapter<SubscriptionsAdapter.SubscriptionViewHolder> {
    private Context context;
    private ArrayList<Podcast> podcasts;

    public SubscriptionsAdapter(Context context, ArrayList<Podcast> podcasts) {
        this.context = context;
        this.podcasts = podcasts;
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
        return podcasts.size();
    }

    private void sendIntent(Podcast podcast){
        Intent intent = new Intent();
        intent.putExtra("id", podcast.getId());
        context.startActivity(intent);
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder{
        ImageView poster;
        TextView podcast_name;
        public SubscriptionViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.podcast_poster);
            podcast_name = itemView.findViewById(R.id.tv_podcast_name);
        }
    }
}
