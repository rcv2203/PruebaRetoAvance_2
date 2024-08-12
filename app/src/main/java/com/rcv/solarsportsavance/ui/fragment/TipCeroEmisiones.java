package com.rcv.solarsportsavance.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class TipCeroEmisiones extends Fragment {
    private boolean isTextVisible = false;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tip_cero_emisiones, container, false);

        Button btnCeroEmisiones = view.findViewById(R.id.btn_tip_cero_emisiones_mostrar_ocultar);
        textView = view.findViewById(R.id.cero_emisiones);

        String text = "1. Cero Emisiones durante el Uso: \n" + "\n" +
                "A diferencia de las fuentes de energía fósil, como el carbón y el petróleo, \n" +
                "la energía solar no produce emisiones de dióxido de carbono (CO2) ni otros gases de efecto invernadero durante su generación. \n" +
                "Esto ayuda a reducir la cantidad de gases nocivos que contribuyen al cambio climático.\n" + "\n" +
                "2. Fomento de la Energía Limpia: Adoptar energía solar puede contribuir a una comunidad más sostenible.\n" + "\n" +
                "3. Menor Contaminación del Aire: La generación de electricidad a partir de paneles solares no produce contaminantes atmosféricos como el \n" +
                "óxidos de nitrógeno (NOx) o el dióxido de azufre (SO2), que son comunes en las plantas de energía fósil y contribuyen a la formación de smog y problemas respiratorios.\n" + "\n" +
                "4. Conservación de Recursos Naturales\n" +
                "Menor Consumo de Agua: Las plantas de energía solar no necesitan agua para enfriar sus equipos, a diferencia de las plantas de energía térmica que usan grandes cantidades de agua. Esto es especialmente importante en regiones secas donde el agua es un recurso escaso." + "\n" + "\n" +
                "5. Reducción de Impactos Ambientales: Las instalaciones solares suelen tener un impacto ambiental menor que las plantas de energía \n" + "\n" +
                "convencionales, que pueden causar deforestación, degradación del suelo y perturbación de hábitats naturales.\n" + "\n";

        SpannableString spannableString = new SpannableString(text);

        // Define los estilos para cada sección del texto
        applySpan(spannableString, "1. Cero Emisiones durante el Uso:", 20, Color.GREEN);
        applySpan(spannableString, "2. Fomento de la Energía Limpia:", 20, Color.GREEN);
        applySpan(spannableString, "3. Menor Contaminación del Aire:", 20, Color.GREEN);
        applySpan(spannableString, "4. Conservación de Recursos Naturales", 20, Color.GREEN);
        applySpan(spannableString, "5. Reducción de Impactos Ambientales:", 20, Color.GREEN);

        // Asigna el SpannableString al TextView
        textView.setText(spannableString);
        textView.setVisibility(View.GONE); // Oculta el texto inicialmente

        btnCeroEmisiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTextVisible) {
                    textView.setVisibility(View.GONE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                }
                isTextVisible = !isTextVisible;
            }
        });
        return view;
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
