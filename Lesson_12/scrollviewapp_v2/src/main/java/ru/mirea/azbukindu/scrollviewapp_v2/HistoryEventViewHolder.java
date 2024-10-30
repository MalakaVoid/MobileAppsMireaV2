package ru.mirea.azbukindu.scrollviewapp_v2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryEventViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private ImageView imageView;

    public HistoryEventViewHolder(@NonNull View itemView){
        super(itemView);

        title = itemView.findViewById(R.id.text);
        imageView = itemView.findViewById(R.id.image);

    }

    public TextView getTitle() {
        return title;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
