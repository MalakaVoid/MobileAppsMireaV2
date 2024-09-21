package ru.mirea.azbukindu.booksproject.domain.usecases;

import ru.mirea.azbukindu.booksproject.data.repository.BooksRepository;
import ru.mirea.azbukindu.booksproject.data.repository.CommentRepository;
import ru.mirea.azbukindu.booksproject.domain.models.Book;
import ru.mirea.azbukindu.booksproject.domain.models.Comment;

public class GetCommentsUseCase {

    private CommentRepository commentRepository;

    public GetCommentsUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment[] execute(){
        return this.commentRepository.getComments("test_id");
    }

}
