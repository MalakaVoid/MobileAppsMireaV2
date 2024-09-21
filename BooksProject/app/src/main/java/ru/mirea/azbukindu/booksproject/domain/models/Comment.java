package ru.mirea.azbukindu.booksproject.domain.models;

import java.util.Date;

public class Comment {

    private int id;
    private String bookId;
    private String username;
    private String text;
    private Date commentDate;


    public Comment(int id, String username, String text, Date commentDate) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.commentDate = commentDate;
    }

    public static Comment getCommentForTest(){
        return new Comment(1, "test_user", "comment_text", new Date());
    }

}
