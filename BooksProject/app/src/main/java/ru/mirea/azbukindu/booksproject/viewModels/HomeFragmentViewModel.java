package ru.mirea.azbukindu.booksproject.viewModels;

import android.content.Context;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.azbukindu.data.apiContoller.BooksApiController;
import ru.mirea.azbukindu.data.repository.BooksRepositoryImpl;
import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.usecases.GetAllBooksUseCase;

public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private MediatorLiveData<List<Book>> allBooks = new MediatorLiveData<>();
    private BooksApiController booksApiController;
    private GetAllBooksUseCase getAllBooksUseCase;
    private final Context context;

    public HomeFragmentViewModel(Context context){
        this.context = context;

        booksApiController = new BooksApiController();
        BooksRepositoryImpl booksRepository = new BooksRepositoryImpl(booksApiController);
        getAllBooksUseCase = new GetAllBooksUseCase(booksRepository);
        allBooks.addSource(books, books -> {
            getBooksLiveData(books);
        });
    }

    public void getAllBooks(){
        getAllBooksUseCase.execute(new ApiRequestCallback<List<Book>>() {
            @Override
            public void onSuccess(List<Book> result) {
                books.setValue(result);
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("ERROR BOOKS API GET ALL BOOKS");
            }
        });
    }

    private void getBooksLiveData(List<Book> books){
        allBooks.setValue(books);
    }

    public MediatorLiveData<List<Book>> getAllBooksLiveData(){
        return allBooks;
    }

}
