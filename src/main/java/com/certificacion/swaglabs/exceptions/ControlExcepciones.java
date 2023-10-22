package com.certificacion.swaglabs.exceptions;

import com.certificacion.swaglabs.util.Severidad;

import static com.certificacion.swaglabs.util.Severidad.SEVERIDAD_MEDIA;

public class ControlExcepciones extends RuntimeException{

    private static final Severidad serialVersionUID = SEVERIDAD_MEDIA;
    private static final String ERROR = "Error al abrir el portal de paros";

    public ControlExcepciones(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR;
    }
}