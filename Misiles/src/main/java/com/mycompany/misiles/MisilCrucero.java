package com.mycompany.misiles;

import java.time.LocalDate;

public class MisilCrucero extends Misil implements Calificable, Interceptable {
    private final double velocidadMach;

    public MisilCrucero(String pais, LocalDate fecha, int alcance, String objetivo, double velocidadMach) {
        super(pais, fecha, alcance, objetivo);
        this.velocidadMach = velocidadMach;
    }

    @Override
    public void calificarAmenaza(int puntaje) throws CalificacionInvalidaException {
        if (puntaje < 1 || puntaje > 10) {
            throw new CalificacionInvalidaException("Puntaje fuera de rango (1-10)");
        }
        System.out.println("Misil crucero calificado con: " + puntaje);
    }

    @Override
    public boolean puedeSerInterceptado() {
        return velocidadMach < 3.0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Crucero, Velocidad: " + velocidadMach + " Mach]";
    }
}

