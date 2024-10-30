package ru.mirea.azbukindu.data.repository;

import java.util.List;

import ru.mirea.azbukindu.data.apiContoller.BooksApi;
import ru.mirea.azbukindu.data.apiContoller.BooksApiController;
import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.models.User;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class BooksRepositoryImpl implements BooksRepository {

    private User user;
    private BooksApiController booksApiController;

    public BooksRepositoryImpl(BooksApiController booksApiController) {
        this.booksApiController = booksApiController;
    }


    public void getAllBooks(ApiRequestCallback<List<Book>> apiRequestCallback){
        booksApiController.getBooks(apiRequestCallback);
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
