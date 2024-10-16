package ru.mirea.azbukindu.domain.usecases;

import ru.mirea.azbukindu.domain.models.Comment;
import ru.mirea.azbukindu.domain.repository.CommentRepository;

public class AddCommentUseCase {

    private CommentRepository commentRepository;

    public AddCommentUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment execute(){
        return this.commentRepository.addComment("test_id", "comment_test");
    }

}
