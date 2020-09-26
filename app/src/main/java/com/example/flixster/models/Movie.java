package com.example.flixster.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private String title;
    private String overview;
    private String portImage;
    private String landImage;
    private Double voteAverage;

    public Movie(JSONObject jsonObject) throws JSONException {
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        portImage = jsonObject.getString("poster_path");
        landImage = jsonObject.getString("backdrop_path");
        voteAverage = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i  <movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPortImage() {
        return "https://image.tmdb.org/t/p/w342/" + portImage;
    }

    public String getLandImage() {
        return "https://image.tmdb.org/t/p/w342/" + landImage;
    }
}
