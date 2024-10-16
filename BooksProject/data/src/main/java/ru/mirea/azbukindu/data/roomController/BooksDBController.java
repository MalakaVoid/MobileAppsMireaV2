package ru.mirea.azbukindu.data.roomController;

import ru.mirea.azbukindu.data.roomController.models.Book;

public interface BooksDBController {

    public void getBooks();
    public void addBook(Book book);
    public void removeBook(Integer id);

}
