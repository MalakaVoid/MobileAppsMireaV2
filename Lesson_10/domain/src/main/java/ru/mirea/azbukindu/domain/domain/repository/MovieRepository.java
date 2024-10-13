package ru.mirea.azbukindu.domain.domain.repository;

import ru.mirea.azbukindu.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
