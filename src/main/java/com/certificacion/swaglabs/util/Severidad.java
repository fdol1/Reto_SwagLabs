package com.certificacion.swaglabs.util;

public enum Severidad {

    SEVERIDAD_ALTA(6),
    SEVERIDAD_MEDIA(4),
    SEVERIDAD_BAJA(2);

    private final int nivelSeveridad;

    Severidad(int nivelSeveridad) {
        this.nivelSeveridad = nivelSeveridad;
    }

    @Override
    public String toString() {
        return "Severidad{" +
                "nivelSeveridad=" + nivelSeveridad +
                '}';
    }
}