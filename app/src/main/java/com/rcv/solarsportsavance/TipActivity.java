package com.rcv.solarsportsavance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.rcv.solarsportsavance.ui.fragment.EnergiaRenovable;
import com.rcv.solarsportsavance.ui.fragment.TipCeroEmisiones;
import com.rcv.solarsportsavance.ui.fragment.Videos;

import java.util.Arrays;
import java.util.List;

public class TipActivity extends AppCompatActivity {

    private boolean isFragmentVisible = false;
    ImageButton btn_regresaLoging;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        Button btnEnergiaRenovable = findViewById(R.id.btn_tip_energia_renovable);
        Button btnAhorroEnergia = findViewById(R.id.btn_tip_ahorro_energia);
        Button btnTipCeroEmisiones = findViewById(R.id.btn_tip_cero_emisiones);

        btnEnergiaRenovable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_renovable);
                if (fragment == null) {
                    fragment = new EnergiaRenovable();
                    fragmentTransaction.add(R.id.fragment_renovable, fragment);
                } else {
                    fragmentTransaction.remove(fragment);
                    fragment = null; // Reset fragment to null so it can be added again
                }
                fragmentTransaction.commit();
            }
        });

        btnTipCeroEmisiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar el fragmento
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_cero_emisiones);

                if (fragment == null) {
                    fragment = new TipCeroEmisiones();
                    fragmentTransaction.add(R.id.fragment_cero_emisiones, fragment);

                } else {
                    fragmentTransaction.remove(fragment);
                    fragment = null; // Reset fragment to null so it can be added again
                }
                fragmentTransaction.commit();
            }
        });

        // Declaramos una variable para almacenar el estado del fragmento.

        btnAhorroEnergia = findViewById(R.id.btn_tip_ahorro_energia);
        btnAhorroEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Busca el fragmento actualmente asociado al contenedor especificado.
                Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

                if (isFragmentVisible) {
                    // Si el fragmento es visible, lo eliminamos.
                    if (fragment != null) {
                        fragmentTransaction.remove(fragment);
                    }
                    // Actualizamos el estado del fragmento.
                    isFragmentVisible = false;
                } else {
                    // Si el fragmento no es visible, lo agregamos al contenedor.
                    if (fragment == null) {
                        fragment = new TipCeroEmisiones();
                        fragmentTransaction.add(R.id.fragment_container, fragment);
                    } else {
                        // Si ya hay un fragmento en el contenedor, solo hacemos visible el fragmento.
                        fragmentTransaction.show(fragment);
                    }
                    // Actualizamos el estado del fragmento.
                    isFragmentVisible = true;
                }

                fragmentTransaction.commit();
            }
        });
            ///////////////////////////////////////////////////////

        Button btnVideos = findViewById(R.id.btn_videos);
        FrameLayout fragmentContainer = findViewById(R.id.fragment_videos);

        btnVideos.setOnClickListener(v -> {
            if (fragmentContainer.getVisibility() == View.VISIBLE) {
                fragmentContainer.setVisibility(View.GONE);
            } else {
                fragmentContainer.setVisibility(View.VISIBLE);
            }
        });

        // Configura la lista de videos
        List<Video> videoList = Arrays.asList(
                new Video("https://www.youtube.com/watch?v=h20bJDZCaCk", "Video 1", "\n" +
                        "En este vídeo didáctico podemos ver qué es la energía solar fotovoltaica y los diferentes tipos de paneles solares que existen."),
                new Video("https://www.youtube.com/watch?v=5MKOe44upAc", "Video 2", "¿Quieres saber qué es la ENERGÍA SOLAR? En este vídeo de EcologíaVerde te explicamos todo lo que debes saber sobre esta ENERGÍA RENOVABLE. Empezaremos explicando la definición de ENERGÍA SOLAR y seguidamente te hablaremos sobre sus VENTAJAS y DESVENTAJAS. Por último, te explicaremos para qué sirve la energía solar, destacando sus usos más comunes. ¡Descúbrelo todo sobre la energía solar!"),
                new Video("https://www.youtube.com/watch?v=W_1AJV8rKU4", "Video 3", "¿Qué sabes sobre la energía solar? ¿Cuáles son sus ventajas y desventajas? En este nuevo vídeo de EcologíaVerde hablaremos de los tipos que existen, cuáles son las ventajas o los beneficios de la energía solar pero, también, de las desventajas de la energía solar y qué saber cuando queremos tener energía solar en casa"),
                new Video("https://www.youtube.com/watch?v=llltWMPievk", "Video 4", "Colombia \uD83C\uDDE8\uD83C\uDDF4 avanza en el fortalecimiento de su capacidad técnica en energía solar con la creación del primer Laboratorio de Sistemas Solares Fotovoltaicos para colegios públicos, ubicado en el Instituto Técnico Industrial Rafael Reyes de Duitama Boyacá. La construcción cuenta con equipamiento de última generación y un enfoque CDIO (concebir, diseñar, implementar y operar)."),
                new Video("https://www.youtube.com/watch?v=lbEHW6E0_wA", "Video 5", "¿Qué es energía solar? La energía solar es aquella que se obtiene directamente del sol, este tipo de energía es renovable porque utiliza la energía del sol, que, en este caso, actúa como una fuente natural e inagotable. La energía solar puede ser producida por la luz o la radiación (energía solar fotovoltaica) o también por el calor (energía solar térmica)")

                //https://www.youtube.com/watch?v=9MdVutpkR8Y
                // Agrega más videos aquí
        );

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Crea una instancia del fragmento con la lista de videos
            Videos videosFragment = Videos.newInstance(videoList);

            // Añade el fragmento al FrameLayout
            fragmentTransaction.add(R.id.fragment_videos, videosFragment);
            fragmentTransaction.commit();
        }

        btn_regresaLoging = findViewById(R.id.btn_regresa_login);
        btn_regresaLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}





