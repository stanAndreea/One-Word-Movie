package com.example.moviejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extra = getIntent().getExtras();

        String poster = extra.getString(MovieActivity.EXTRA_POSTER);
        String name = extra.getString(MovieActivity.EXTRA_NAME);
        String overview = extra.getString(MovieActivity.EXTRA_OVERVIEW);
        double vote = extra.getDouble(MovieActivity.EXTRA_VOTE);

        ImageView posterView = findViewById(R.id.image_view_poster);
        TextView nameView = findViewById(R.id.text_view_name);
        TextView voteView = findViewById(R.id.text_view_vote);
        TextView overviewView = findViewById(R.id.text_view_overview);

        if (poster.equals("null")) {
            posterView.setImageResource(R.drawable.no_poster_movie);
        }else{
            Picasso.get().load(poster).fit().centerInside().into(posterView);
        }
        nameView.setText(name);
        overviewView.setText(overview);
        voteView.setText(String.valueOf(vote));

    }
}
