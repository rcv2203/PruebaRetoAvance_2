package com.rcv.solarsportsavance.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rcv.solarsportsavance.R;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class DetalleAhorroEnergia extends Fragment {
    private boolean isTextVisible = false;
    private Button btnAhorroEnergia, btnCeroEmiosiones;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_detalle_ahorro_energia, container, false);

        // Inicializa los componentes de la vista
        btnAhorroEnergia = view.findViewById(R.id.btn_tip_ahorro_energia);
        textView = view.findViewById(R.id.textViewDetalle);

        // Define el texto
        String text = "1. Ahorro Económico a Largo Plazo \n" +
                "Reducción de Facturas de Energía: \n" + "\n" +
                "La energía solar puede reducir significativamente las facturas de electricidad. A pesar de la inversión inicial, " +
                "a largo plazo, los costos de energía pueden disminuir considerablemente.\n" + "\n" +
                "Incentivos y Subsidios: \n" + "\n" +
                "Muchos gobiernos ofrecen incentivos y subsidios para la instalación de sistemas solares, lo que puede reducir el costo inicial.\n" + "\n" +
                "Incremento en el Valor de la Propiedad\n" + "\n" +
                "Valor de Reventa: Las propiedades con instalaciones de energía solar pueden tener un valor de reventa más alto, ya que los compradores valoran los ahorros en los costos de energía.\n" + "\n" +
                "2. Incremento en el Valor de la Propiedad\n" + "\n" +
                "Valor de Reventa: Las propiedades con instalaciones de energía solar pueden tener un valor de reventa más alto, ya que los compradores valoran los ahorros en los costos de energía.\n" + "\n" +
                "3. Beneficios Ambientales\n" + "\n" +
                "Reducción de Emisiones: La energía solar es una fuente de energía limpia que no emite gases de efecto invernadero ni contaminantes.\n" +
                "Conservación de Recursos Naturales: A diferencia de los combustibles fósiles, la energía solar es renovable y no agota los recursos naturales.";

        SpannableString spannableString = new SpannableString(text);

        // Define los estilos para cada sección del texto
        applySpan(spannableString, "1. Ahorro Económico a Largo Plazo", 20, Color.GREEN);
        applySpan(spannableString, "Reducción de Facturas de Energía:", 18, Color.BLACK);
        applySpan(spannableString, "Incremento en el Valor de la Propiedad", 20, Color.BLACK);
        applySpan(spannableString, "2. Incremento en el Valor de la Propiedad", 20, Color.BLACK);
        applySpan(spannableString, "3. Beneficios Ambientales", 20, Color.GREEN);

        // Asigna el SpannableString al TextView
        textView.setText(spannableString);
        textView.setVisibility(View.GONE); // Oculta el texto inicialmente

        // Configura el botón para alternar la visibilidad del TextView
        btnAhorroEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("DetalleAhorroEnergia", "Botón clickeado. Estado actual del texto: " + (isTextVisible ? "VISIBLE" : "GONE"));
                if (isTextVisible) {
                    textView.setVisibility(View.GONE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                }
                isTextVisible = !isTextVisible;
            }
        });

        return view;

        //TERMINA BTN_AHORRO DE ENERGIA
    }

    private void applySpan(SpannableString spannableString, String keyword, int textSize, int color) {
        int start = spannableString.toString().indexOf(keyword);
        if (start != -1) {
            int end = start + keyword.length();
            spannableString.setSpan(new StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new AbsoluteSizeSpan(textSize, true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}

