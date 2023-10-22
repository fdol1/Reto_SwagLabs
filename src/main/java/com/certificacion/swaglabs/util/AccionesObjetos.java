package com.certificacion.swaglabs.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.certificacion.swaglabs.util.Constantes.*;

public class AccionesObjetos {

    public AccionesObjetos() {
    }

    public static Double convertirNumero(String dato) {

        Locale locale = new Locale(OPCION_IDIOMA, OPCION_PAIS);
        double numeroConvertido = 0;
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        String numeroRecibido = dato;
        numeroRecibido = numeroRecibido.replaceAll("[^\\d.]", "");
        try {
            Number number = numberFormat.parse(numeroRecibido);
            numeroConvertido = number.doubleValue();
        } catch (ParseException e) {
            System.err.println(OPCION_ERROR_CONVERTIR_CADENA);
        }
        return numeroConvertido;
    }

    public static Object[] ordenarLista(List<Double> listaOrdenadaPrecios, List<String> listaOrdenadaTitulos, boolean mayorOMenor) {
        boolean intercambiado;
        do {
            intercambiado = false;
            for (int i = 1; i < listaOrdenadaPrecios.size(); i++) {
                boolean condicion = mayorOMenor ? (listaOrdenadaPrecios.get(i - 1) < listaOrdenadaPrecios.get(i)) : (listaOrdenadaPrecios.get(i - 1) > listaOrdenadaPrecios.get(i));

                if (condicion) {
                    Double precioTem = listaOrdenadaPrecios.get(i - 1);
                    String tituloTem = listaOrdenadaTitulos.get(i - 1);

                    listaOrdenadaPrecios.set(i - 1, listaOrdenadaPrecios.get(i));
                    listaOrdenadaTitulos.set(i - 1, listaOrdenadaTitulos.get(i));

                    listaOrdenadaPrecios.set(i, precioTem);
                    listaOrdenadaTitulos.set(i, tituloTem);
                    intercambiado = true;
                }
            }
        } while (intercambiado);

        return new Object[]{listaOrdenadaPrecios, listaOrdenadaTitulos};
    }
}