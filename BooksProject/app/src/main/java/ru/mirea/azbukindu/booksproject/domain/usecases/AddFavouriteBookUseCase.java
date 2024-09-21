package ru.mirea.azbukindu.booksproject.domain.usecases;

import java.util.Date;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Book;

public class AddFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public AddFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.addFavouriteBook(Book.getBookForTest());
    }

}
