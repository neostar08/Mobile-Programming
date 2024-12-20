package com.example.project145.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project145.Adapter.FilmListAdapter;
import com.example.project145.Domain.Datum;
import com.example.project145.Domain.FilmItem;
import com.example.project145.Domain.ListFilm;
import com.example.project145.R;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewNewMovies;
    private ProgressBar loading1;
    private static final String API_URL = "https://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=6708a951d98e017406bfdb2a8e602755";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        fetchMovies();
    }

    private void initView() {
        recyclerViewNewMovies = findViewById(R.id.view1);
        loading1 = findViewById(R.id.loading1);
        recyclerViewNewMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void fetchMovies() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        loading1.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_URL, response -> {
            try {
                // Decoding the response
                String decodedResponse = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                Log.d("API Response", decodedResponse);

                // Parsing the JSON response
                Gson gson = new Gson();
                ListFilm listFilm = gson.fromJson(decodedResponse, ListFilm.class);

                // Handle the parsed data
                if (listFilm != null && listFilm.hasData()) {
                    updateUI(mapDatumToFilmItem(listFilm.getData()));
                    // You can also access the metadata here
                    if (listFilm.getMetadata() != null) {
                        Log.d("Metadata", "Total Count: " + listFilm.getMetadata().getTotalCount());
                    }
                } else {
                    Log.e("MainActivity", "No data available in API response.");
                    loading1.setVisibility(View.GONE);
                }
            } catch (Exception e) {
                Log.e("MainActivity", "Parsing error: " + e.getMessage());
                loading1.setVisibility(View.GONE);
            }
        }, error -> {
            loading1.setVisibility(View.GONE);
            Log.e("MainActivity", "Network error: " + error.toString());
        });

        requestQueue.add(stringRequest);
    }

    private void updateUI(List<FilmItem> items) {
        loading1.setVisibility(View.GONE);
        if (items != null && !items.isEmpty()) {
            recyclerViewNewMovies.setAdapter(new FilmListAdapter(items));
        } else {
            Log.e("MainActivity", "No items to display.");
        }
    }

    private List<FilmItem> mapDatumToFilmItem(List<Datum> data) {
        List<FilmItem> filmItems = new ArrayList<>();
        if (data == null) return filmItems;

        for (Datum datum : data) {
            FilmItem filmItem = new FilmItem();
            filmItem.setId(String.valueOf(datum.getId()));
            filmItem.setTitle(datum.getTitle());
            filmItem.setPoster(datum.getPoster());
            filmItem.setYear(String.valueOf(datum.getYear()));
            filmItem.setImdbRating(String.valueOf(datum.getImdbRating()));
            filmItems.add(filmItem);
        }
        return filmItems;
    }
}
