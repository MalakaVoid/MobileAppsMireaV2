package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class DeleteFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public DeleteFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.deleteFavouriteBook(Book.getBookForTest());
    }

}
