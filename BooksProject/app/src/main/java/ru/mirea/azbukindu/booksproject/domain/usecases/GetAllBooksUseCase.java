package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Book;

public class GetAllBooksUseCase {

    private BooksRepository booksRepository;

    public GetAllBooksUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book[] execute(){
        return this.booksRepository.getAllBooks();
    }

}
