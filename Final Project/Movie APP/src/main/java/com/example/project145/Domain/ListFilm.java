package com.example.project145.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListFilm {

    @SerializedName("data")
    @Expose
    private List<Datum> data;

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public List<Datum> getData() {
        return data;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    // Additional helper methods if needed
    public boolean hasData() {
        return data != null && !data.isEmpty();
    }
}
