package ru.mirea.azbukindu.data.roomController.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "book")
public class Book {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "title")
    private String description;

    @ColumnInfo(name = "picturePath")
    private String picturePath;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "publishDate")
    private String publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
