package ru.mirea.azbukindu.booksproject.data.repository;

import java.util.Date;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public class BooksRepository {

    protected User user;

    public Book[] getAllBooks(){
        return new Book[] {Book.getBookForTest()};
        // достаем книги из апи
    }

    public Book getBook(String bookId){
        return Book.getBookForTest();
        // достаем книгу из апи по id
    }

    public Book[] getFavouriteBooks(){
        return new Book[] {Book.getBookForTest()};
        // достаем из бд избранное
    }

    public boolean addFavouriteBook(Book book){
        return true;
        //Добавляет в бд запись
    }

    public boolean deleteFavouriteBook(Book book){
        return true;
        //удаляет из бд запись
    }

}
