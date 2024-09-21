package ru.mirea.azbukindu.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.azbukindu.movieproject.data.MovieRepositoryImpl;
import ru.mirea.azbukindu.movieproject.domain.models.Movie;
import ru.mirea.azbukindu.movieproject.domain.repository.MovieRepository;
import ru.mirea.azbukindu.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.azbukindu.movieproject.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textData);

        MovieRepository movieRepository = new MovieRepositoryImpl(getApplicationContext());
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new
                        SaveMovieToFavoriteUseCase(movieRepository).execute(new Movie(2,
                        text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });

        findViewById(R.id.buttonShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie moview = new GetFavoriteFilmUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", moview.getName()));
            }
        });
    }
}
