package com.example.moviejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity implements MovieAdapter.OnItemClickLisene {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private List<Movie> moviesList;
    private RequestQueue requestQueue;
    private TextView textView;
    private ImageView imageView;
    public static final String EXTRA_POSTER= "poster";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_YEAR= "year";
    public static final String EXTRA_VOTE = "vote";
    public static final String EXTRA_OVERVIEW = "overview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Bundle b = getIntent().getExtras();
        assert b != null;
        String nameUrl = b.getString(MainActivity.EXTRA_NAME_URL);

         textView =findViewById(R.id.movie_layout_text);
         imageView = findViewById(R.id.movie_layout_image);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        moviesList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        parseJSON(nameUrl);
    }



    private void parseJSON(String nameUrl) {
        String url = "https://api.themoviedb.org/3/search/movie?query="+nameUrl+"&api_key=<<api_key>>";

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray = response.getJSONArray("results");
                    if (jsonArray.length() == 0 ){
                        imageView.setVisibility(View.VISIBLE);
                        textView.setVisibility(View.VISIBLE);
                    }else{
                        imageView.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);
                        for(int i=0; i< jsonArray.length(); i++){
                            JSONObject currentObject = jsonArray.getJSONObject(i);

                            String posterMovieUrl = currentObject.getString("poster_path");
                            String nameMovie = currentObject.getString("title");
                            String yearMovie = currentObject.getString("release_date");
                            double voteMovie = currentObject.getDouble("vote_average");
                            String overviewMovie = currentObject.getString("overview");

                            String poster;
                            if (posterMovieUrl.equals("null")){
                                //because i want my poster empty
                                poster= "null";
                            }else{
                                poster = "http://image.tmdb.org/t/p/w185/"+posterMovieUrl;
                            }
                            moviesList.add(new Movie(poster, nameMovie, yearMovie,voteMovie,overviewMovie));
                        }
                        movieAdapter = new MovieAdapter(MovieActivity.this,moviesList);
                        recyclerView.setAdapter(movieAdapter);

                        movieAdapter.setOnItemClickLisene(MovieActivity.this);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onItemClick(int position) {
        Movie currentMovie = moviesList.get(position);
        Intent intent = new Intent(MovieActivity.this,DetailsActivity.class);

        intent.putExtra(EXTRA_NAME,currentMovie.getNameMovie());
        intent.putExtra(EXTRA_POSTER,currentMovie.getImageMovieUrl());
        intent.putExtra(EXTRA_YEAR,currentMovie.getYearMovie());
        intent.putExtra(EXTRA_VOTE,currentMovie.getVoteMovie());
        intent.putExtra(EXTRA_OVERVIEW,currentMovie.getOverview());

        startActivity(intent);

    }
}
