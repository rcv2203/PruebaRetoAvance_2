package com.rcv.solarsportsavance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PresupuestoEstadioMainActivity extends AppCompatActivity {
    TextView datosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto_estadio_main);

        // Recuperar el TextView para mostrar los datos
        datosTextView = findViewById(R.id.datos_textview);

        // Obtener los datos de la intención
        Intent intent = getIntent();
        String establecimiento = intent.getStringExtra("establecimiento");
        double consumoMensual = intent.getDoubleExtra("consumoMensual", 0.0);
        double consumoAnual = intent.getDoubleExtra("consumoAnual", 0.0);
        double valorHora = intent.getDoubleExtra("valorHora", 0.0);
        String direccion = intent.getStringExtra("direccion");
        String fecha = intent.getStringExtra("Fecha");

        // Mostrar los datos en el TextView
        String datosString = "Establecimiento: " + establecimiento + "\n" +
                "Consumo Mensual: " + consumoMensual + "\n" +
                "Consumo Anual: " + consumoAnual + "\n" +
                "Valor Hora: " + valorHora + "\n" +
                "Dirección: " + direccion  + "\n" +
                "Fecha: " + fecha;

        datosTextView.setText(datosString);

    }

}