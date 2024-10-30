package ru.mirea.azbukindu.domain.usecases;

import java.util.List;

import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.repository.BooksRepository;

public class GetAllBooksUseCase {

    private BooksRepository booksRepository;

    public GetAllBooksUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void execute(ApiRequestCallback<List<Book>> apiRequestCallback){
        this.booksRepository.getAllBooks(apiRequestCallback);
    }

}
