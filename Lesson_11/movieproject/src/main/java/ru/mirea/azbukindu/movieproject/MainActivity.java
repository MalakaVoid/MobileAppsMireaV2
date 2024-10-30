package ru.mirea.azbukindu.movieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.azbukindu.data.data.MovieRepositoryImpl;
import ru.mirea.azbukindu.data.data.storage.MovieStorage;
import ru.mirea.azbukindu.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.azbukindu.domain.domain.models.Movie;
import ru.mirea.azbukindu.domain.domain.repository.MovieRepository;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainActivityViewModel.class);

        EditText text = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textData);

        viewModel.getFavoriteMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(String.format("Save result: %s", s));
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setText(new Movie(2, text.getText().toString()));
            }
        });

        findViewById(R.id.buttonShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getText();
            }
        });
    }


}

