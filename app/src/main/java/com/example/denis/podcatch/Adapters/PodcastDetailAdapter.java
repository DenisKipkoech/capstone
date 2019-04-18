package com.example.denis.podcatch.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.denis.podcatch.Models.Episode;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class PodcastDetailAdapter extends RecyclerView.Adapter<PodcastDetailAdapter.PodcastViewHolder>{
    private Context context;
    private ArrayList<Episode> episodes;
    final private ItemClickListener itemClickListener;

    public PodcastDetailAdapter(Context context, ArrayList<Episode> episodes, ItemClickListener listener) {
        this.context = context;
        this.episodes = episodes;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.podcast_detail, parent, false);
        return new PodcastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastViewHolder holder, int position) {
        final Episode episode = episodes.get(holder.getAdapterPosition());

        holder.episode_name.setText(episode.getTitle());
        holder.duration.setText(timeFormat(episode.getAudioLength()));
        holder.date.setText(dateFormat(episode.getPubDateMs()));

    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    private String dateFormat(Long timestamp){
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(timestamp);
        return android.text.format.DateFormat
                .format("dd-MM-yyyy", calendar).toString();

    }

    private String timeFormat(Long timestamp){
        return (timestamp%60) + " min";
    }

    public interface ItemClickListener{
        void onItemClickListener(String audioUrl, String posterUrl);
    }

    public class PodcastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView episode_name, duration, date;
      public PodcastViewHolder(View itemView) {
          super(itemView);
          episode_name = itemView.findViewById(R.id.tv_episode_name);
          duration = itemView.findViewById(R.id.tv_duration);
          date = itemView.findViewById(R.id.tv_date);

          itemView.setOnClickListener(this);
      }

        @Override
        public void onClick(View v) {
          String url = episodes.get(getAdapterPosition()).getAudio();
          String poster = episodes.get(getAdapterPosition()).getThumbnail();
            itemClickListener.onItemClickListener(url, poster);
        }
    }
}
