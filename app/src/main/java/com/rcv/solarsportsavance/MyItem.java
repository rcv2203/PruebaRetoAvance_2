package com.rcv.solarsportsavance;


import java.util.Calendar;

public class MyItem {
    private String name;
    private double consumoMensual;
    private double consumoAnual;
    private double consumoPorHora;
    private double numeroDePaneles;
    private double areaDelPanel;


    public MyItem(String name, double consumoMensual, double consumoPorHora, double numeroDePaneles, double areaDelPanel) {
        this.name = name;
        this.consumoMensual = consumoMensual;
        this.consumoAnual = consumoMensual * 12;
        this.consumoPorHora = calcularConsumoPorHora();
        this.numeroDePaneles = calcularNumeroDePaneles(consumoMensual);
        this.areaDelPanel = calcularAreaDelPanel(numeroDePaneles * areaDelPanel);

    }

    private static final double CAPACIDAD_PANEL_KWP = 0.3; // Capacidad del panel en kWp
    private static final double HORAS_SOL_PROMEDIO_DIA = 5; // Horas de sol promedio por día
    private static final int DIAS_EN_EL_MES = 30; // Días en el mes

    private static final double AREA_DE_UN_PANEL = 1.6; //m²

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

    private double calcularAreaDelPanel(double v) {
        areaDelPanel = numeroDePaneles * AREA_DE_UN_PANEL;  //Area deun panel comercial 1.6 m²
        return areaDelPanel;
    }

    public String getName() {
        return name;
    }

    public double getConsumoMensual() {
        return consumoMensual;
    }

    public double getConsumoAnual() {
        return consumoAnual;
    }

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    public double getNumeroDePaneles() {
        return numeroDePaneles;
    }

    public double getAreaDelPanel() {
        return areaDelPanel;
    }


}
