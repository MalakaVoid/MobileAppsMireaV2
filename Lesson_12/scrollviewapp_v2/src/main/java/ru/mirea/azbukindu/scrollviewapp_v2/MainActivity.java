package ru.mirea.azbukindu.scrollviewapp_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<HistoryEvent> historyEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyEvents.add(new HistoryEvent("Первая мировая война", "image1"));
        historyEvents.add(new HistoryEvent("Лунная высадка", "image2"));
        historyEvents.add(new HistoryEvent("Открытие Америки", "image3"));
        historyEvents.add(new HistoryEvent("Падение Берлинской стены", "image4"));

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView wrapper = findViewById(R.id.wrapper);
        wrapper.setAdapter(new HistoryEventAdapter(historyEvents));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        wrapper.setLayoutManager(linearLayoutManager);
    }

}