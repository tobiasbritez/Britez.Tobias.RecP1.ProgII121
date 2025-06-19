package com.mycompany.misiles;

import java.time.LocalDate;

public class MisilAntibuque extends Misil implements Interceptable {
    private final boolean preciso;

    public MisilAntibuque(String pais, LocalDate fecha, int alcance, String objetivo, boolean preciso) {
        super(pais, fecha, alcance, objetivo);
        this.preciso = preciso;
    }

    @Override
    public boolean puedeSerInterceptado() {
        return !preciso;
    }

    @Override
    public String toString() {
        return super.toString() + " [Antibuque, Preciso: " + preciso + "]";
    }
}
