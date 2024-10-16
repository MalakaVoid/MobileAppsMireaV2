package ru.mirea.azbukindu.domain.repository;

import ru.mirea.azbukindu.domain.models.Book;

public interface BooksRepository {

    public Book[] getAllBooks();

    public Book getBook(String bookId);

    public Book[] getFavouriteBooks();

    public boolean addFavouriteBook(Book book);

    public boolean deleteFavouriteBook(Book book);

}
