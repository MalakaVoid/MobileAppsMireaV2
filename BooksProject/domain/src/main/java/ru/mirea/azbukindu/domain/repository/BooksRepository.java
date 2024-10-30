package ru.mirea.azbukindu.domain.repository;

import java.util.List;

import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;

public interface BooksRepository {

    public void getAllBooks(ApiRequestCallback<List<Book>> apiRequestCallback);

    public Book getBook(String bookId);

    public Book[] getFavouriteBooks();

    public boolean addFavouriteBook(Book book);

    public boolean deleteFavouriteBook(Book book);

}
