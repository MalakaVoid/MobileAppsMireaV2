package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class AddFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public AddFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.addFavouriteBook(Book.getBookForTest());
    }

}
