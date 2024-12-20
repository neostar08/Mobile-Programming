package com.example.project145.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.project145.Adapter.ImageListAdapter;
import com.example.project145.Domain.FilmItem;
import com.example.project145.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private ProgressBar progressBar;
    private TextView titleTxt, movieRateTxt, movieTimeTxt, movieDateTxt, movieSummaryInfo, movieActorsInfo;
    private NestedScrollView scrollView;
    private int idFilm;
    private ShapeableImageView pic1;
    private ImageView pic2, backImg;
    private RecyclerView.Adapter adapterImgList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        idFilm = getIntent().getIntExtra("id", 0); // Retrieve the ID passed to this activity
        initView(); // Initialize all views
        sendRequest(); // Fetch and display movie details
    }

    private void sendRequest() {
        mRequestQueue = Volley.newRequestQueue(this);
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=6708a951d98e017406bfdb2a8e602755" + idFilm;

        mStringRequest = new StringRequest(Request.Method.GET, url, response -> {
            Gson gson = new Gson();
            progressBar.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);

            // Parse the response to a FilmItem object
            FilmItem item = gson.fromJson(response, FilmItem.class);

            // Update UI with movie details
            Glide.with(DetailActivity.this)
                    .load(item.getPoster())
                    .into(pic1);

            Glide.with(DetailActivity.this)
                    .load(item.getPoster())
                    .into(pic2);

            titleTxt.setText(item.getTitle() != null ? item.getTitle() : "N/A");
            movieRateTxt.setText(item.getRated() != null ? item.getRated() : "N/A");
            movieTimeTxt.setText(item.getRuntime() != null ? item.getRuntime() : "N/A");
            movieDateTxt.setText(item.getReleased() != null ? item.getReleased() : "N/A");
            movieSummaryInfo.setText(item.getPlot() != null ? item.getPlot() : "N/A");
            movieActorsInfo.setText(item.getActors() != null ? item.getActors() : "N/A");

            if (item.getImages() != null) {
                adapterImgList = new ImageListAdapter(item.getImages());
                recyclerView.setAdapter(adapterImgList);
            }

        }, error -> {
            progressBar.setVisibility(View.GONE);
            Log.e("DetailActivity", "Error fetching details: " + error.toString());
        });

        mRequestQueue.add(mStringRequest);
    }

    private void initView() {
        titleTxt = findViewById(R.id.movieNameTxt);
        progressBar = findViewById(R.id.detailLoding);
        scrollView = findViewById(R.id.scrollView3);
        pic1 = findViewById(R.id.posterNormalImg);
        pic2 = findViewById(R.id.posterBigImg);
        movieRateTxt = findViewById(R.id.movieRateTxt);
        movieTimeTxt = findViewById(R.id.movieTimeTxt);
        movieDateTxt = findViewById(R.id.movieDateTxt);
        movieSummaryInfo = findViewById(R.id.movieSummaryInfo);
        movieActorsInfo = findViewById(R.id.movieActorInfo);
        backImg = findViewById(R.id.backImg);
        recyclerView = findViewById(R.id.imagesRecyclerView);

        // Set RecyclerView layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Add back button functionality
        backImg.setOnClickListener(v -> finish());
    }
}
