package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ItemDetailActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BannerAdapter bannerAdapter;
    private ImageButton btn_regresarMenu;
    ImageButton btn_regresoMenu;

    private static final long DELAY_MS = 3000; // Delay in milliseconds before task is to be executed
    private static final long PERIOD_MS = 3000; // Time in milliseconds between successive task executions

    private TextView textViewDetailName;
    private TextView consumoMensual;
    private TextView textViewDetailConsumoAnual;
    private TextView textViewDetailConsumoHora;
    private TextView numeroDePaneles;
    private TextView areaParaPaneles;

    @SuppressLint({"MissingInflatedId", "DefaultLocale", "WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        textViewDetailName = findViewById(R.id.textViewDetailName);
        consumoMensual = findViewById(R.id.textViewConsumoMensual);
        textViewDetailConsumoAnual = findViewById(R.id.textViewDetailConsumoAnual);
        textViewDetailConsumoHora = findViewById(R.id.textViewDetailConsumoHora);
        numeroDePaneles = findViewById(R.id.textViewDetailNumeroPaneles);
        areaParaPaneles = findViewById(R.id.textViewDetailAreaPaneles);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double textViewConsumoMensual = intent.getDoubleExtra("consumo mensual", 0);
        double amount = intent.getDoubleExtra("amount", 0);
        double textViewConsumoHora = intent.getDoubleExtra("consumo por hora", 0);
        double textViewDetailNumeroPaneles = intent.getDoubleExtra("numero de paneles", 0);
        double textViewDetailAreaPaneles = intent.getDoubleExtra("area para paneles", 0);


        textViewDetailName.setText(name);
        consumoMensual.setText(String.format("%.2f ", textViewConsumoMensual));
        textViewDetailConsumoAnual.setText(String.format("%.2f ", textViewConsumoMensual * 12));
        textViewDetailConsumoHora.setText(String.format("%.2f ", textViewConsumoHora));
        numeroDePaneles.setText(String.format("%d ", (int) Math.round(textViewDetailNumeroPaneles)));
        areaParaPaneles.setText(String.format("%d ", (int) Math.round(textViewDetailAreaPaneles)));

        //Inicio del banner
        viewPager = findViewById(R.id.viewPager);

        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://gruposolinc.com/wp-content/uploads/2019/01/Estadio-Mineirao-Belo-Horizonte.jpg");
        imageUrls.add("https://tritec-intervento.cl/wp-content/uploads/2020/04/e78736aca0d62703da4c068930371cce-768x576.jpg");
        imageUrls.add("https://gruposolinc.com/wp-content/uploads/2019/01/Estadio-Nacional-de-Kaohsiung-Taiw%C3%A1n.jpeg");
        imageUrls.add("https://images.adsttc.com/media/images/55e6/2651/4d8d/5d5b/4700/0150/medium_jpg/world-games-stadium_3_urhdv_69.jpg?1441146443");
        imageUrls.add("https://farm6.staticflickr.com/5565/14833610401_02be1cf081_z.jpg");
        imageUrls.add("https://www.ambientesoluciones.com/portal/userfiles/caso6-2.jpg?1622751708187");
        imageUrls.add("https://solarlinerenovables.com/wp-content/uploads/2023/04/Solar-Powered-NFL-Stadium.png.webp");
        imageUrls.add("https://www.ambientesoluciones.com/userfiles/images/3%284%29.jpg");

        bannerAdapter = new BannerAdapter(this, imageUrls);
        viewPager.setAdapter(bannerAdapter);

        // Auto scroll banner
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable update = new Runnable() {
            public void run() {
                if (viewPager.getCurrentItem() == imageUrls.size() - 1) {
                    viewPager.setCurrentItem(0);
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);

        //Fin del banner


        btn_regresarMenu = findViewById(R.id.btn_regresar_menu);
        btn_regresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        Button btn_guardar_datos = findViewById(R.id.guardar_datos_datail);
        btn_guardar_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos de los EditTexts
                String editTextNombre = textViewDetailName.getText().toString();
                double consumoMensual_ = Double.parseDouble(consumoMensual.getText().toString());
                double consumoHora_ = Double.parseDouble(textViewDetailConsumoHora.getText().toString());
                double cantidadPaneles_ = Double.parseDouble(numeroDePaneles.getText().toString());
                double areaPaneles_ = Double.parseDouble(areaParaPaneles.getText().toString());

                gurdarDatos(editTextNombre, consumoMensual_, consumoHora_, cantidadPaneles_, areaPaneles_);

                Toast.makeText(getApplicationContext(), "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

            }
        });

        btn_regresoMenu = findViewById(R.id.btn_regresar_menu);
        btn_regresoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


    }

    private void gurdarDatos(String editTextNombre, double consumoMensual, double consumoHora, double cantidadPaneles, double areaPaneles) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;

        try {
            // Define el nombre del archivo
            File archivo = new File(getFilesDir(), "datos_establecimiento.txt");

            // Abre un flujo de salida de archivo
            fos = new FileOutputStream(archivo, true); // "true" para agregar al archivo si ya existe
            bw = new BufferedWriter(new OutputStreamWriter(fos));

            String name = editTextNombre.toUpperCase();

            // Define el ancho máximo de los campos para alinear
            int maxNombreLength = 30;
            int maxConsumoMensualLength = 30;
            int maxConsumoHoraLength = 30;
            int maxCantidadPanelesLength = 30;
            int maxAreaPanelesLength = 30;

            // Escribe los datos en el archivo
            bw.write(String.format("%-" + maxNombreLength + "s : %s", "Nombre del Establecimiento: ", editTextNombre));
            bw.newLine();
            bw.write(String.format("%-" + maxConsumoMensualLength + "s : %.2f kWh", "Consumo Mensual", consumoMensual));
            bw.newLine();
            bw.write(String.format("%-" + maxConsumoHoraLength + "s : %.2f kWh", "Consumo por Hora", consumoHora));
            bw.newLine();
            bw.write(String.format("%-" + maxCantidadPanelesLength + "s : %.0f paneles", "Cantidad de Paneles", cantidadPaneles));
            bw.newLine();
            bw.write(String.format("%-" + maxAreaPanelesLength + "s : %.2f m²", "Área de Paneles", areaPaneles));
            bw.newLine();
            bw.newLine(); // Línea en blanco entre registros para separar las entradas

            // Cierra el BufferedWriter
            bw.flush();
            //Log.d("Archivo", "Datos guardados en: " + archivo.getAbsolutePath()); // Agregar este log
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Asegúrate de cerrar el BufferedWriter y FileOutputStream
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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









