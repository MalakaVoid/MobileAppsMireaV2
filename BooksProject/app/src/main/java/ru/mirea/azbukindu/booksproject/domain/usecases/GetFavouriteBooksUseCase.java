package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.repository.BooksRepository;

public class GetFavouriteBooksUseCase {

    private BooksRepository booksRepository;

    public GetFavouriteBooksUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book[] execute(){
        return this.booksRepository.getFavouriteBooks();
    }

}
