package com.rcv.solarsportsavance.ui.estadio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rcv.solarsportsavance.ListActivity;
import com.rcv.solarsportsavance.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextConsumoMensual;

//    private EditText editTextConsumoAnual;
//    private EditText editTextConsumoHora;
//    private EditText editTextCantidaPaneles;

    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextName = findViewById(R.id.editTextName);
        editTextConsumoMensual = findViewById(R.id.editTextConsumoMensual);

//        editTextConsumoAnual = findViewById(R.id.editTextConsumoAnual);
//        editTextConsumoHora = findViewById(R.id.editTextConsumoHora);
//        editTextCantidaPaneles = findViewById(R.id.editTextCantidaPaneles);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(v -> submitData());
    }

    private void submitData() {
        String name = editTextName.getText().toString();
        String consumoMensualStr = editTextConsumoMensual.getText().toString();

//        String consumoAnualStr = editTextConsumoAnual.getText().toString();
//        String consumoHoraStr = editTextConsumoHora.getText().toString();
//        String cantidadPanelesStr = editTextCantidaPaneles.getText().toString();
        if (name.isEmpty() || consumoMensualStr.isEmpty()) {
            Toast.makeText(this, "Todos los campos deben ser llenados", Toast.LENGTH_SHORT).show();
            return;
        }

        double consumoMensual = Double.parseDouble(consumoMensualStr);

        // Guardar datos en archivo
        saveDataToFile(name, consumoMensual);

        // Enviar los datos a la siguiente actividad
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("consumo mensual", consumoMensual);

        startActivity(intent);
    }

    private void saveDataToFile(String name, double consumoMensual) {
        FileOutputStream fos = null;
        try {
            // Obtener el archivo en el almacenamiento interno
            File file = new File(getFilesDir(), "data.txt");
            fos = new FileOutputStream(file, true); // Abrir en modo append

            // Crear una cadena con los datos
            String data = name + "\n" + consumoMensual;
//                    consumoAnual + "\n" +
//                    consumoHora + "\n" +
//                    cantidadPaneles;

            fos.write(data.getBytes());

            Toast.makeText(this, "Datos guardados en archivo", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}