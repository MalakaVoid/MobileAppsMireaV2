package ru.mirea.azbukindu.data.roomController;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.azbukindu.data.roomController.models.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BooksDB extends RoomDatabase {

    public abstract BooksDAO getBooksDAO();

}
