package ru.mirea.azbukindu.booksproject.domain.repository;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public interface BooksRepository {

    public Book[] getAllBooks();

    public Book getBook(String bookId);

    public Book[] getFavouriteBooks();

    public boolean addFavouriteBook(Book book);

    public boolean deleteFavouriteBook(Book book);

}
