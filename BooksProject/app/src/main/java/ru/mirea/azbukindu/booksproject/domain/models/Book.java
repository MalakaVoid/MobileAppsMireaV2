package ru.mirea.azbukindu.booksproject.domain.models;

import java.util.Date;

public class Book {
    private String id;
    private String description;
    private String picturePath;
    private String author;
    private String genre;
    private Date publishDate;

    public Book(String id, String description, String picturePath, String author, String genre, Date publishDate) {
        this.id = id;
        this.description = description;
        this.picturePath = picturePath;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
    }

    public static Book getBookForTest(){
        return new Book("1", "description", "/1", "Author", "Action", new Date());
    }

}
