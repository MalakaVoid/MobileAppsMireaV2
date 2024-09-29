package ru.mirea.azbukindu.booksproject.domain.repository;

import ru.mirea.azbukindu.booksproject.domain.models.Comment;
import ru.mirea.azbukindu.booksproject.domain.models.User;

public interface CommentRepository {

    public Comment[] getComments(String bookId);

    public Comment addComment(String bookId, String text);

}
