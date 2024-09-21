package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Book;

public class DeleteFavouriteBookUseCase {

    private BooksRepository booksRepository;

    public DeleteFavouriteBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public boolean execute(){
        return this.booksRepository.deleteFavouriteBook(Book.getBookForTest());
    }

}
