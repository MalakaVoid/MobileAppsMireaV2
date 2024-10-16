package ru.mirea.azbukindu.data.repository;

import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.models.User;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class BooksRepositoryImpl implements BooksRepository {

    private User user;

    public BooksRepositoryImpl(User user) {
        this.user = user;
    }


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
