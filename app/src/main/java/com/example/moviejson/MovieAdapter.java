package com.example.moviejson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private Context context;
    private List<Movie> moviesList;
    private OnItemClickLisene onItemClickLisene;

    public interface  OnItemClickLisene{
        void onItemClick(int position);
    }

    public void setOnItemClickLisene(OnItemClickLisene lisener){
        onItemClickLisene = lisener;
    }

    public MovieAdapter(Context context, List<Movie> movies){
        this.context = context;
        moviesList = movies;

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovieItem = moviesList.get(position);

        String imageMovieUrl = currentMovieItem.getImageMovieUrl();
        String nameMovie = currentMovieItem.getNameMovie();
        String yearMovie = currentMovieItem.getYearMovie();

       // holder.nameMovieView.setText(nameMovie);
       // holder.yearMovieView.setText(yearMovie);
        if (imageMovieUrl.equals("null")){
            holder.posterMovieView.setImageResource(R.drawable.no_poster);
        }else{
            Picasso.get().load(imageMovieUrl).fit().centerInside().into(holder.posterMovieView);
        }


    }


    @Override
    public int getItemCount() {
        // return number of movies are in the list @moviesList
        return moviesList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        public ImageView posterMovieView ;
        public TextView nameMovieView;
        public TextView yearMovieView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            posterMovieView = itemView.findViewById(R.id.poster_image_view);
           // nameMovieView = itemView.findViewById(R.id.text_movie_name);
            //yearMovieView = itemView.findViewById(R.id.year_movie_text_view);


           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(onItemClickLisene != null){
                       int position = getAdapterPosition();
                       if(position != RecyclerView.NO_POSITION){
                           onItemClickLisene.onItemClick(position);
                       }
                   }
               }
           });
        }
    }
}
