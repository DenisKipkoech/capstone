package com.example.denis.podcatch.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.denis.podcatch.Models.Category;
import com.example.denis.podcatch.Models.Podcast;
import com.example.denis.podcatch.Models.Results;
import com.example.denis.podcatch.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private Context context;
    private ArrayList<Category> categories;

    public MainAdapter(Context context, ArrayList<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.category, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final Category category = categories.get(holder.getAdapterPosition());

        PodcastCategoryAdapter adapter = new PodcastCategoryAdapter(context,
                (ArrayList<Podcast>) category.getPodcasts());
        holder.category.setText(category.getTitle());
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,
                false));
        holder.recyclerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        RecyclerView recyclerView;
        public MainViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.tv_category);
            recyclerView = itemView.findViewById(R.id.rv_category);
        }
    }
}
