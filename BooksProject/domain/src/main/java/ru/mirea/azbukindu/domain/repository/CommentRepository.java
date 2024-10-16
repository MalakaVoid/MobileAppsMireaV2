package ru.mirea.azbukindu.domain.repository;

import ru.mirea.azbukindu.domain.models.Comment;

public interface CommentRepository {

    public Comment[] getComments(String bookId);

    public Comment addComment(String bookId, String text);

}
