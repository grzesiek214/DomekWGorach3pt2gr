package com.example.domekwgorach3pt2gr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static int licznikPolubien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textViewPolubienia = findViewById(R.id.textViewPolubienia);

        Button buttonPolub = findViewById(R.id.buttonPolub);
        Button buttonUsun = findViewById(R.id.buttonUsun);
        Button buttonZapisz = findViewById(R.id.buttonZapisz);

        buttonPolub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikPolubien++;
                        textViewPolubienia.setText(String.valueOf(licznikPolubien) + " polubień");
                    }
                }
        );

        buttonUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (licznikPolubien == 0) return;
                        licznikPolubien--;
                        textViewPolubienia.setText(String.valueOf(licznikPolubien) + " polubień");
                    }
                }
        );
    }
}