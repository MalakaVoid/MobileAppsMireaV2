package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.repository.BooksRepository;

public class AddFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public AddFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.addFavouriteBook(Book.getBookForTest());
    }

}
