package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView consumoMensual;
    private TextView consumoAnual;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewName = findViewById(R.id.textViewName);
        consumoMensual = findViewById(R.id.textViewConsumoMensual);
        consumoAnual = findViewById(R.id.textViewConsumoAnual);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double consumoMensual_ = intent.getDoubleExtra("consumo mensual", 0);
        double amount = intent.getDoubleExtra("amount", 0);
        double consumoAnual_ = intent.getDoubleExtra("consumo anual", 0);


        textViewName.setText(name);
        consumoMensual.setText(String.valueOf(consumoMensual_));
        consumoAnual.setText(String.valueOf(consumoAnual_));
    }
}
