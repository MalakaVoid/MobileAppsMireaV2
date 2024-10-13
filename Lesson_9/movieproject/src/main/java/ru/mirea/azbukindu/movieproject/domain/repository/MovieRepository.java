package ru.mirea.azbukindu.movieproject.domain.repository;

import ru.mirea.azbukindu.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
