package ru.mirea.azbukindu.data.roomController;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.azbukindu.data.roomController.models.Book;

public class RoomBooksDBController implements BooksDBController{

    private BooksDB booksDB;
    private Context context;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RoomBooksDBController(Context context) {
        this.context = context;

        booksDB = Room.databaseBuilder(context, BooksDB.class, "AnimeDB")
                .build();
    }

    @Override
    public void getBooks() {
        executorService.execute(() -> booksDB.getBooksDAO().getAllBook());
    }

    @Override
    public void addBook(Book book) {
        executorService.execute(() -> booksDB.getBooksDAO().addBook(book));
    }

    @Override
    public void removeBook(Integer id) {
        executorService.execute(() -> booksDB.getBooksDAO().removeBook(id));
    }

}
