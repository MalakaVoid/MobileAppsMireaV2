package ru.mirea.azbukindu.movieproject;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.azbukindu.domain.domain.models.Movie;
import ru.mirea.azbukindu.domain.domain.repository.MovieRepository;
import ru.mirea.azbukindu.domain.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.azbukindu.domain.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivityViewModel extends ViewModel {

    private MovieRepository movieRepository;

    private MutableLiveData<String> favoriteMovie = new MutableLiveData<>();

    public MutableLiveData<String> getFavoriteMovie() {
        return favoriteMovie;
    }

    public MainActivityViewModel(MovieRepository movieRepository) {
        Log.d(MainActivityViewModel.class.getSimpleName().toString(), "MainActivityViewModel created");
        this.movieRepository = movieRepository;
    }

    @Override
    protected void onCleared() {
        Log.d(MainActivityViewModel.class.getSimpleName().toString(), "MainActivityViewModel cleared");
        super.onCleared();
    }

    public boolean setText(Movie movie){
        Boolean result = new SaveMovieToFavoriteUseCase(movieRepository).execute(movie);

        favoriteMovie.setValue(result.toString());
        return result;
    }
    public Movie getText(){
        Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();

        favoriteMovie.setValue(movie.getName());
        return movie;
    }

}
