package ru.mirea.azbukindu.data.apiContoller;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.azbukindu.domain.ApiRequestCallback;
import ru.mirea.azbukindu.domain.models.Book;
import ru.mirea.azbukindu.domain.models.BooksApiResponse;

public class BooksApiController {

    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private final BooksApi booksApi; //

    public BooksApiController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        booksApi = retrofit.create(BooksApi.class);
    }

    public void getBooks(ApiRequestCallback<List<Book>> apiCallback) {
        booksApi.getBooks().enqueue(new Callback<BooksApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<BooksApiResponse> call, @NonNull retrofit2.Response<BooksApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    apiCallback.onSuccess(response.body().getItems());
                } else {
                    apiCallback.onFailure(new Exception("Something went wrong"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<BooksApiResponse> call, @NonNull Throwable t) {
                apiCallback.onFailure((Exception) t);
            }
        });
    }


}
