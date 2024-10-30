package ru.mirea.azbukindu.data.apiContoller;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mirea.azbukindu.domain.models.BooksApiResponse;

public interface BooksApi {

    @GET("volumes?q=a&maxResults=20")
    Call<BooksApiResponse> getBooks();

}
