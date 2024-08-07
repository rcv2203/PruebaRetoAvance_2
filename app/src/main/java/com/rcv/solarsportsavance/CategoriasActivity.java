package com.rcv.solarsportsavance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rcv.solarsportsavance.ui.estadio.FormActivity;

public class CategoriasActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        spinner = findViewById(R.id.spinner_registrar_categorias);

        String[] elementos = {"Escoja la categoría", "Estadio", "Parque", "Gimnacio", "Pista"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                String elementoSeleccionado = (String) parentView.getItemAtPosition(position);
                Toast.makeText(CategoriasActivity.this, "Seleciono: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();
                Log.d("CategoriasActivity", "Elemento seleccionado: " + elementoSeleccionado);

                switch (elementoSeleccionado) {
                    case "Estadio":
                        Intent intentE = new Intent(CategoriasActivity.this, FormActivity.class);
                        startActivity(intentE);
                        //Toast.makeText(getApplicationContext(),"Puedes registrar tu estadio", Toast.LENGTH_SHORT).show();
                        break;
//                    case (elementoSeleccionado) {
//                            "Parque":
//                        Intent intentP = new Intent(CategoriasActivity.this, RegistrarParque.class);
//                        startActivity(intentp);
//                        break;

                    default:
                        // Código para manejar casos no cubiertos
                        Toast.makeText(getApplicationContext(), "Opción no válida", Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acción a realizar cuando no se selecciona ningún elemento

            }
        });
    }
}