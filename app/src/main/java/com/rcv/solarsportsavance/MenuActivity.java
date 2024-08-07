package com.rcv.solarsportsavance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button btn_menuCategoria, btn_beneficios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_menuCategoria = findViewById(R.id.btn_categorias);
        btn_beneficios = findViewById(R.id.btn_beneficios);

        btn_beneficios.setOnClickListener(v -> tip());

        btn_menuCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCategorias = new Intent(MenuActivity.this, CategoriasActivity.class);
                startActivity(intentCategorias);
                Toast.makeText(getApplicationContext(),"Selecciona una categoría", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void tip() {
        Intent intenTip = new Intent(getApplicationContext(), TipActivity.class);
        startActivity(intenTip);
    }
}