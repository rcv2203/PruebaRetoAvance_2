package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<MyItem> itemList;
    //Este es adicionado en el paso 4
    private TextView consumoMensual;
    private TextView consumoPorHora;
    private TextView numeroDePaneles;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Una vez creado el textViewTotal ir al archivo activity_list.xml y crearlo
        consumoMensual = findViewById(R.id.textViewConsumoMensual);
        consumoPorHora = findViewById(R.id.textViewDetailConsumoHora);
        numeroDePaneles = findViewById(R.id.textViewDetailNumeroPaneles);


        // Obtener los datos del Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double consumoMensual_ = intent.getDoubleExtra("consumo mensual", 0);
        double consumoPorHora_ = intent.getDoubleExtra("consumo por hora" , 0);
        double numeroDePaneles_ = intent.getDoubleExtra("numero de paneles", 0);


        itemList = new ArrayList<>();
        itemList.add(new MyItem(name, consumoMensual_, consumoPorHora_, numeroDePaneles_));


        myAdapter = new MyAdapter(itemList, item -> {
            Intent detailIntem = new Intent(ListActivity.this, ItemDetailActivity.class);
            detailIntem.putExtra("name", item.getName());
            detailIntem.putExtra("consumo mensual", item.getConsumoMensual());
            detailIntem.putExtra("consumo por hora", item.getConsumoPorHora());
            detailIntem.putExtra("numero de paneles" ,item.getNumeroDePaneles());
            startActivity(detailIntem);
        });

        recyclerView.setAdapter(myAdapter);


        // Calcular y mostrar el total

    }

    private double calculateAnnualConsumption(List<MyItem> items) {
        double total = 0;
        for (MyItem item : items) {
            total += item.getConsumoAnual();
        }
        return total;
    }

}

