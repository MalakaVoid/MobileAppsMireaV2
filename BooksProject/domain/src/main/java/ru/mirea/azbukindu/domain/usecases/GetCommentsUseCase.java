package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.models.Comment;
import ru.mirea.azbukindu.domain.repository.CommentRepository;

public class GetCommentsUseCase {

    private CommentRepository commentRepository;

    public GetCommentsUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment[] execute(){
        return this.commentRepository.getComments("test_id");
    }

}
