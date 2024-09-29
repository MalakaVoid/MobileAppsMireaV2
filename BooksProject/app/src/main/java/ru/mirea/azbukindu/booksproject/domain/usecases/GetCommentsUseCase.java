package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.domain.models.Comment;
import ru.mirea.azbukindu.booksproject.domain.repository.CommentRepository;

public class GetCommentsUseCase {

    private CommentRepository commentRepository;

    public GetCommentsUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment[] execute(){
        return this.commentRepository.getComments("test_id");
    }

}
