package ru.mirea.azbukindu.booksproject.data;

import ru.mirea.azbukindu.booksproject.data.repository.CommentRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Comment;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public class CommentRepositoryImpl extends CommentRepository {

    public CommentRepositoryImpl(User user) {
        this.user = user;
    }
}
