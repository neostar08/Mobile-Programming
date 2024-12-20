package com.example.project145.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project145.R;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {
    private List<String> images = new ArrayList<>(); // Initialize to avoid null pointer issues
    private Context context;

    public ImageListAdapter(List<String> images) {
        if (images != null) {
            this.images = images;
        }
    }

    @NonNull
    @Override
    public ImageListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_detail_images, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ViewHolder holder, int position) {
        if (position < images.size()) {
            String imageUrl = images.get(position);

            Glide.with(context)
                    .load(imageUrl != null && !imageUrl.isEmpty() ? imageUrl : R.drawable.placeholder_image)
                    .into(holder.pic);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setImages(List<String> images) {
        if (images != null) {
            this.images = images;
            notifyDataSetChanged();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.itemImages);
        }
    }
}
