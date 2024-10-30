package ru.mirea.azbukindu.scrollviewapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeNumbers();
    }

    private void makeNumbers() {
        LinearLayout scrollView = findViewById(R.id.wrapper);

        BigInteger lastNumber = new BigInteger("1");
        for (int i = 0; i < 100; i++){
            View view = getLayoutInflater().inflate(R.layout.item, null, false);

            TextView text = (TextView)view.findViewById(R.id.text);
            text.setText(lastNumber.toString());
            lastNumber = lastNumber.multiply(new BigInteger("2"));

            scrollView.addView(view);
        }
    }


}