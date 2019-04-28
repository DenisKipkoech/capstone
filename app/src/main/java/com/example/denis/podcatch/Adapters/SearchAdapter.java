package com.example.denis.podcatch.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Search;
import com.example.denis.podcatch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private Context context;
    private ArrayList<Search> episodes = null;
    final private  ItemClickListener clickListener;

    public SearchAdapter(Context context, ItemClickListener listener) {
        this.context = context;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.subscription, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        final Search episode = episodes.get(holder.getAdapterPosition());
        Picasso.with(context)
                .load(episode.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.poster);

        holder.podcast_name.setText(episode.getTitleOriginal());

    }

    @Override
    public int getItemCount() {
        if (episodes == null) {
            return 0;
        }
        return episodes.size();
    }

    public void setEpisodes(ArrayList<Search> episodes) {
        this.episodes = episodes;
        notifyDataSetChanged();
    }

    public interface ItemClickListener{
        void onItemClickListener(Episode episode);
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView poster;
        TextView podcast_name;
        public SearchViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.podcast_poster);
            podcast_name = itemView.findViewById(R.id.tv_podcast_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Search search = episodes.get(getAdapterPosition());
            Episode episode = new Episode(
                    search.getPubDateMs()
                    ,search.getListennotesUrl()
                    ,search.getId()
                    ,search.getImage()
                    ,search.getTitleOriginal()
                    ,search.getThumbnail()
                    ,search.getAudio()
                    ,search.getAudioLength()
            );
            clickListener.onItemClickListener(episode);
        }
    }
}
