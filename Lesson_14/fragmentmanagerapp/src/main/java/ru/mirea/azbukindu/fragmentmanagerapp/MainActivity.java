package ru.mirea.azbukindu.fragmentmanagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ShareViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ShareViewModel.class);
        viewModel.getSomeValue().observe(this, item -> {

        });
        CountryList countryList = CountryList.newInstance("MIREA");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_view, countryList, "header")
                    .add(R.id.detail_fragment_container, new InfoFragment(), "details")
                    .commit();
        }
    }
}