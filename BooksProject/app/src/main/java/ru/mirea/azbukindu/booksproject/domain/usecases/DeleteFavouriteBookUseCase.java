package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.repository.BooksRepository;

public class DeleteFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public DeleteFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.deleteFavouriteBook(Book.getBookForTest());
    }

}
