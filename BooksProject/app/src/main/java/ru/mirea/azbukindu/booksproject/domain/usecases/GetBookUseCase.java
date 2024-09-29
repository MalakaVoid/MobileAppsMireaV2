package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.repository.BooksRepository;

public class GetBookUseCase {

    private BooksRepository booksRepository;

    public GetBookUseCase(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book execute(){
        return this.booksRepository.getBook("test_id");
    }

}
