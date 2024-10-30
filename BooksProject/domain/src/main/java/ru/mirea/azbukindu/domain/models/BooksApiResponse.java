package ru.mirea.azbukindu.domain.models;

import java.util.List;

public class BooksApiResponse {

    private String kind;
    private int totalItems;
    private List<Book> items;

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<Book> getItems() {
        return items;
    }
}
