package com.rcv.solarsportsavance;


import java.util.Calendar;

public class MyItem {
    private String name;
    private double consumoMensual;
    private double consumoAnual;
    private double consumoPorHora;
    private double numeroDePaneles;


    public MyItem(String name, double consumoMensual, double consumoPorHora, double numeroDePaneles) {
        this.name = name;
        this.consumoMensual = consumoMensual;
        this.consumoAnual = consumoMensual * 12;
        this.consumoPorHora = calcularConsumoPorHora();
        this.numeroDePaneles = calcularNumeroDePaneles(consumoMensual);

    }


    private static final double CAPACIDAD_PANEL_KWP = 0.3; // Capacidad del panel en kWp
    private static final double HORAS_SOL_PROMEDIO_DIA = 5; // Horas de sol promedio por día
    private static final int DIAS_EN_EL_MES = 30; // Días en el mes

    private double calcularNumeroDePaneles(double consumoMensual) {
        double produccionMensualPorPanel = CAPACIDAD_PANEL_KWP * HORAS_SOL_PROMEDIO_DIA * DIAS_EN_EL_MES;
        return consumoMensual / produccionMensualPorPanel;
    }

    private double calcularConsumoPorHora() {
        Calendar calendar = Calendar.getInstance();
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int hoursInMonth = daysInMonth * 24;
        return consumoMensual / hoursInMonth;

    }

    public String getName() {
        return name;
    }
    public double getConsumoMensual() { return consumoMensual; }
    public double getConsumoAnual() { return consumoAnual; }
    public double getConsumoPorHora() {
        return consumoPorHora;
    }
    public double getNumeroDePaneles() {return numeroDePaneles; }


}
