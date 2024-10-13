package ru.mirea.azbukindu.movieproject.data.repository;

import ru.mirea.azbukindu.movieproject.domain.models.Movie;

public class MovieRepository {
    public boolean saveMovie(Movie movie) {
        return true;
    }

    public Movie getMovie() {
        return new Movie(1,"Doctor Strange");
    }
}
