package com.mycompany.misiles;

import java.time.LocalDate;


public class MisilBalistico extends Misil implements Calificable {
    private final boolean cargaNuclear;
    private final NivelAmenaza nivelAmenaza;

    public MisilBalistico(String pais, LocalDate fecha, int alcance, String objetivo,
                          boolean cargaNuclear, NivelAmenaza nivelAmenaza) {
        super(pais, fecha, alcance, objetivo);
        this.cargaNuclear = cargaNuclear;
        this.nivelAmenaza = nivelAmenaza;
    }

    public NivelAmenaza getNivelAmenaza() {
        return nivelAmenaza;
    }

    @Override
    public void calificarAmenaza(int puntaje) throws CalificacionInvalidaException {
        if (puntaje < 1 || puntaje > 10) {
            throw new CalificacionInvalidaException("Puntaje fuera de rango (1-10)");
        }
        System.out.println("Misil balístico calificado con: " + puntaje);
    }

    @Override
    public String toString() {
        return super.toString() + " [Balístico, Carga Nuclear: " + cargaNuclear +
               ", Amenaza: " + nivelAmenaza + "]";
    }
}

