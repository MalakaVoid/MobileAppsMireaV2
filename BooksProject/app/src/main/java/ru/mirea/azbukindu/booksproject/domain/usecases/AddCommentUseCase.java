package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.CommentRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Comment;

public class AddCommentUseCase {

    private CommentRepository commentRepository;

    public AddCommentUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment execute(){
        return this.commentRepository.addComment("test_id", "comment_test");
    }

}
