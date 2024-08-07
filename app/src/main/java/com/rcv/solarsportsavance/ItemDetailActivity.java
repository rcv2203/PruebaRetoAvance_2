package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView textViewDetailName;
    private TextView consumoMensual;
    private TextView textViewDetailConsumoAnual;
    private TextView textViewDetailConsumoHora;
    private TextView numeroDePaneles;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        textViewDetailName = findViewById(R.id.textViewDetailName);
        consumoMensual = findViewById(R.id.textViewConsumoMensual);
        textViewDetailConsumoAnual = findViewById(R.id.textViewDetailConsumoAnual);
        textViewDetailConsumoHora = findViewById(R.id.textViewDetailConsumoHora);
        numeroDePaneles = findViewById(R.id.textViewDetailNumeroPaneles);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double textViewConsumoMensual = intent.getDoubleExtra("consumo mensual", 0);
        double amount = intent.getDoubleExtra("amount", 0);
        double textViewConsumoHora = intent.getDoubleExtra("consumo por hora", 0);
        double textViewDetailNumeroPaneles = intent.getDoubleExtra("numero de paneles", 0);

        textViewDetailName.setText(name);
        consumoMensual.setText(String.valueOf(textViewConsumoMensual));
        textViewDetailConsumoAnual.setText(String.valueOf(textViewConsumoMensual * 12));
        textViewDetailConsumoHora.setText(String.valueOf(textViewConsumoHora));
        numeroDePaneles.setText(String.valueOf(textViewDetailNumeroPaneles));


    }

}


