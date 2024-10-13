package ru.mirea.azbukindu.domain.domain.usecases;

import ru.mirea.azbukindu.domain.domain.models.Movie;
import ru.mirea.azbukindu.domain.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}

