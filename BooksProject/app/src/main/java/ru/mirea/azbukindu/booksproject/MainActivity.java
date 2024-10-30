package ru.mirea.azbukindu.booksproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.azbukindu.booksproject.recycleAdapters.AllBooksAdapter;
import ru.mirea.azbukindu.booksproject.viewModels.MainActivityViewModel;
import ru.mirea.azbukindu.booksproject.viewModels.MainActivityViewModelFactory;
import ru.mirea.azbukindu.data.apiContoller.BooksApiController;
import ru.mirea.azbukindu.data.repository.BooksRepositoryImpl;
import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.usecases.GetAllBooksUseCase;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private RecyclerView recyclerView;
    private AllBooksAdapter allBooksAdapter;
    private List<Book> allBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.booksCardsWrapper);
        allBooks = new ArrayList<>();
        allBooksAdapter = new AllBooksAdapter(allBooks);

        recyclerView.setAdapter(allBooksAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this, new MainActivityViewModelFactory(this))
                .get(MainActivityViewModel.class);

        viewModel.getAllBooksLiveData().observe(this, books -> {
            allBooks.clear();
            allBooks.addAll(books);
            allBooksAdapter.notifyDataSetChanged();
        });

        viewModel.getAllBooks();

    }
}