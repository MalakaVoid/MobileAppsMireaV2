package ru.mirea.azbukindu.scrollviewapp_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryEventAdapter extends RecyclerView.Adapter<HistoryEventViewHolder> {

    private List<HistoryEvent> historyEvents;
    private Context context;

    public HistoryEventAdapter(List<HistoryEvent> historyEvents) {
        this.historyEvents = historyEvents;
    }

    @NonNull
    @Override
    public HistoryEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.item, parent,
                        false);
        return new HistoryEventViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryEventViewHolder holder, int position) {
        HistoryEvent historyEvent = this.historyEvents.get(position);
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(historyEvent.getImage(),
                "drawable", pkgName);

        holder.getImageView().setImageResource(resID);
        holder.getTitle().setText(historyEvent.getTitle());
    }

    @Override
    public int getItemCount() {
        return historyEvents.size();
    }
}
