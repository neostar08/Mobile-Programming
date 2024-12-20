package com.example.project145.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project145.Domain.FilmItem;
import com.example.project145.R;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.FilmViewHolder> {
    private final List<FilmItem> filmItems;

    public FilmListAdapter(List<FilmItem> filmItems) {
        this.filmItems = filmItems;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        FilmItem filmItem = filmItems.get(position);

        // Set movie details
        holder.title.setText(filmItem.getTitle());
        holder.year.setText(filmItem.getYear());
        holder.genre.setText(filmItem.getRated() != null ? filmItem.getRated() : "Unknown Genre");
        holder.runtime.setText(filmItem.getRuntime() != null ? filmItem.getRuntime() : "N/A");
        holder.released.setText(filmItem.getReleased() != null ? filmItem.getReleased() : "Unknown Date");
        holder.plot.setText(filmItem.getPlot() != null ? filmItem.getPlot() : "No plot available");
        holder.actors.setText(filmItem.getActors() != null ? filmItem.getActors() : "Unknown actors");

        // Load poster image
        Glide.with(holder.poster.getContext())
                .load(filmItem.getPoster() != null ? filmItem.getPoster() : R.drawable.placeholder_image)
                .into(holder.poster);

        // Set IMDb rating
        holder.rating.setText(String.format("%.1f", filmItem.getImdbRating()));
        holder.ratingBar.setRating((float) (filmItem.getImdbRating() != null ? Double.parseDouble(filmItem.getImdbRating()) / 2.0 : 0)); // IMDb rating out of 10

        // Favorite icon toggle (logic can be added later)
        holder.favoriteIcon.setOnClickListener(v -> {
            // Placeholder: Toggle favorite state
            holder.favoriteIcon.setImageResource(R.drawable.ic_round_favorite_24);
        });
    }

    @Override
    public int getItemCount() {
        return filmItems.size();
    }

    static class FilmViewHolder extends RecyclerView.ViewHolder {
        TextView title, genre, year, runtime, released, plot, actors, rating;
        ImageView poster, favoriteIcon;
        RatingBar ratingBar;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTitle);
            genre = itemView.findViewById(R.id.movieGenre);
            year = itemView.findViewById(R.id.movieYear);
            runtime = itemView.findViewById(R.id.movieRuntime);
            released = itemView.findViewById(R.id.movieReleased);
            plot = itemView.findViewById(R.id.moviePlot);
            actors = itemView.findViewById(R.id.movieActors);
            rating = itemView.findViewById(R.id.movieRating);
            poster = itemView.findViewById(R.id.moviePoster);
            favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
            ratingBar = itemView.findViewById(R.id.movieRatingBar);
        }
    }
}
