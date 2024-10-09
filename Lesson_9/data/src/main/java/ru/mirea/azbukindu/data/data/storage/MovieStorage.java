package ru.mirea.azbukindu.data.data.storage;


import ru.mirea.azbukindu.data.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}
