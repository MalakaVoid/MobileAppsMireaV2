package ru.mirea.azbukindu.retrofitapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrieveTodos();
    }

    private void retrieveTodos() {
        ApiService todoApi = Retrofit.getRetrofitInstance().create(ApiService.class);
        Call<List<Todo>> call = todoApi.getTodos();

        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful()) {
                    todoAdapter = new TodoAdapter(MainActivity.this, response.body());
                    recyclerView.setAdapter(todoAdapter);
                    return;
                }

                Log.e("MAIN DEBUG", "response: " + response.code());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable throwable) {
                Log.e("MAIN DEBUG", "error: " + throwable.getMessage());
            }
        });
    }
}