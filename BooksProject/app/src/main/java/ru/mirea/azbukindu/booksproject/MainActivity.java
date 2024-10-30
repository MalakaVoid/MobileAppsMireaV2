package ru.mirea.azbukindu.booksproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

import ru.mirea.azbukindu.booksproject.viewModels.MainActivityViewModel;
import ru.mirea.azbukindu.booksproject.viewModels.MainActivityViewModelFactory;
import ru.mirea.azbukindu.data.apiContoller.BooksApiController;
import ru.mirea.azbukindu.data.repository.BooksRepositoryImpl;
import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.usecases.GetAllBooksUseCase;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new MainActivityViewModelFactory(this))
                .get(MainActivityViewModel.class);

        viewModel.getAllBooksLiveData().observe(this, books -> {
            for (Book book: books){
                System.out.println(book.getTitle());
            }
        });

        viewModel.getAllBooks();

    }
}