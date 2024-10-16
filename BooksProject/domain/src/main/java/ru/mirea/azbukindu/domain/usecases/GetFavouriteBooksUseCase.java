package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class GetFavouriteBooksUseCase {

    private BooksRepository booksRepository;

    public GetFavouriteBooksUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book[] execute(){
        return this.booksRepository.getFavouriteBooks();
    }

}
