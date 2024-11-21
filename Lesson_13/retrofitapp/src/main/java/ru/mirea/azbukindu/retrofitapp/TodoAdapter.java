package ru.mirea.azbukindu.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Todo> todos;

    public TodoAdapter(Context context, List<Todo> todoList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());

        holder.checkBoxCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            todo.setCompleted(isChecked);
            updateTodoCompletion(todo.getId(), isChecked);
        });

        String[] imageSources = new String[] {
                "https://i0.wp.com/picjumbo.com/wp-content/uploads/silhouette-of-young-blonde-with-short-hair-on-orange-background-free-image.jpeg?h=800&quality=80",
                "https://gratisography.com/wp-content/uploads/2024/10/gratisography-happy-cone-800x525.jpg",
                "https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg"
        };

        Picasso.get()
                .load(imageSources[new Random().nextInt(imageSources.length)])
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .resize(60, 60)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    private void updateTodoCompletion(int todoId, boolean completed) {
        ApiService apiService = Retrofit.getRetrofitInstance().create(ApiService.class);
        Todo targetTodo = todos.get(todoId);
        targetTodo.setCompleted(completed);

        Call<Todo> call = apiService.setTodo(todoId, targetTodo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e("MAIN DEBUG", "response: " + response.code());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e("MAIN DEBUG", "fail:	" + t.getMessage());
            }
        });
    }

}
