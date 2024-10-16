package ru.mirea.azbukindu.data.repository;


import ru.mirea.azbukindu.domain.models.Comment;
import ru.mirea.azbukindu.domain.models.User;
import ru.mirea.azbukindu.domain.repository.CommentRepository;

public class CommentRepositoryImpl implements CommentRepository {

    private User user;

    public CommentRepositoryImpl(User user) {
        this.user = user;
    }


    public Comment[] getComments(String bookId){
        return new Comment[] {Comment.getCommentForTest()};
        // получение комментариев по книге
    }

    public Comment addComment(String bookId, String text){
        return Comment.getCommentForTest();
    }
}
