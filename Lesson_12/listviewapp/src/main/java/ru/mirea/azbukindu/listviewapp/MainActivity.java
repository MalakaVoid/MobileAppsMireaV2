package ru.mirea.azbukindu.listviewapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = new String[] {
                "Война и мир", "1984", "Убить пересмешника", "Гордость и предубеждение",
                "Мастер и Маргарита", "Три товарища", "Преступление и наказание",
                "Анна Каренина", "451 градус по Фаренгейту", "Сияние", "Маленький принц",
                "Старик и море", "Девушка с татуировкой дракона", "Над пропастью во ржи",
                "Братья Карамазовы", "Собачье сердце", "Дон Кихот", "Человек в поисках смысла",
                "Золотой теленок", "Тень горы", "Семь навыков высокоэффективных людей",
                "Унесенные ветром", "Шум и ярость", "Старый и море", "Код да Винчи",
                "В поисках утраченного времени", "Моби Дик", "На маяк", "Скотный двор",
                "Три мушкетера"
        };

        ListView listView = findViewById(R.id.wrapper);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, books);
        listView.setAdapter(arrayAdapter);
    }

}