package ru.mirea.azbukindu.booksproject.recycleAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.mirea.azbukindu.booksproject.R;
import ru.mirea.azbukindu.domain.models.Book;

public class AllBooksAdapter extends RecyclerView.Adapter<AllBooksViewHolder> {

    private List<Book> books;
    private Context context;

    public AllBooksAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public AllBooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.book_card, parent, false);

        return new AllBooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllBooksViewHolder holder, int position) {
        Book book = books.get(position);

        Glide.with(context)
                .load(book.getCoverImage())
                .into(holder.getImage());
        holder.getTitle().setText(book.getTitle());
        holder.getAuthor().setText(book.getAuthor());
    }


    @Override
    public int getItemCount() {
        return books.size();
    }
}
