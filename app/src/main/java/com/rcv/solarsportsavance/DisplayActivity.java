package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView consumoMensual;
    private TextView consumoAnual;
    private TextView areaParaPaneles;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewName = findViewById(R.id.textViewName);
        consumoMensual = findViewById(R.id.textViewConsumoMensual);
        consumoAnual = findViewById(R.id.textViewConsumoAnual);
        areaParaPaneles = findViewById(R.id.textViewAreaPaneles);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double consumoMensual_ = intent.getDoubleExtra("consumo mensual", 0);
        double amount = intent.getDoubleExtra("amount", 0);
        double consumoAnual_ = intent.getDoubleExtra("consumo anual", 0);
        double areaParapanel_ = intent.getDoubleExtra("area Para paneles", 0);

        textViewName.setText(name);
        consumoMensual.setText(String.valueOf(consumoMensual_));
        consumoAnual.setText(String.valueOf(consumoAnual_));
        areaParaPaneles.setText(String.valueOf(areaParapanel_));

    }
}
