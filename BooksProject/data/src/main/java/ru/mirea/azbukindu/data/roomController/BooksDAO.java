package ru.mirea.azbukindu.data.roomController;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.mirea.azbukindu.data.roomController.models.Book;

@Dao
public interface BooksDAO {

    @Query("select * from book")
    public List<Book> getAllBook();

    @Query("select * from book where id==:id")
    public List<Book> getBookById(Integer id);

    @Insert
    public void addBook(Book book);

    @Update
    public void changeBook(Book book);

    @Query("delete from book where id==:id")
    public void removeBook(Integer id);

    @Query("delete from book")
    public void clear();

}
