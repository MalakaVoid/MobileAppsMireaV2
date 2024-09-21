package ru.mirea.azbukindu.booksproject.data;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public class BooksRepositoryImpl extends BooksRepository {

    public BooksRepositoryImpl(User user) {
        this.user = user;
    }
}
