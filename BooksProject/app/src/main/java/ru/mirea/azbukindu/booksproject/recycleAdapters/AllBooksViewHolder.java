package ru.mirea.azbukindu.booksproject.recycleAdapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.azbukindu.booksproject.R;

public class AllBooksViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView author;
    private ImageView image;

    public AllBooksViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.cardTitle);
        author = itemView.findViewById(R.id.cardAuthor);
        image = itemView.findViewById(R.id.cardImage);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getAuthor() {
        return author;
    }

    public ImageView getImage() {
        return image;
    }
}
