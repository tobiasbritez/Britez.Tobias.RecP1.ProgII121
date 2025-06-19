package com.mycompany.misiles;

import java.util.*;
import java.time.LocalDate;

public class SimuladorDeConflicto {
    private final List<Misil> misiles;

    public SimuladorDeConflicto() {
        this.misiles = new ArrayList<>();
    }

    public void lanzarMisil(Misil m) throws AtaqueDuplicadoException {
        for (Misil otro : misiles) {
            if (otro.getPaisLanzador().equals(m.getPaisLanzador()) &&
                otro.getFechaLanzamiento().equals(m.getFechaLanzamiento()) &&
                otro.getObjetivo().equals(m.getObjetivo())) {
                throw new AtaqueDuplicadoException("Misil duplicado detectado.");
            }
        }
        misiles.add(m);
    }

    public void mostrarTodosLosMisiles() {
        misiles.forEach(System.out::println);
    }

    public void interceptarMisiles() {
        for (Misil m : misiles) {
            if (m instanceof Interceptable interceptable) {
                boolean puede = interceptable.puedeSerInterceptado();
                System.out.println(m + " ¿Interceptable?: " + (puede ? "Sí" : "No"));
            }
        }
    }

    public List<MisilBalistico> filtrarBalisticosPorAmenaza(NivelAmenaza nivel) {
        List<MisilBalistico> lista = new ArrayList<>();
        for (Misil m : misiles) {
            if (m instanceof MisilBalistico b) {
                if (b.getNivelAmenaza() == nivel) {
                    lista.add(b);
                }
            }
        }
        lista.forEach(System.out::println);
        return lista;
    }

    public void calificarAtaque(String pais, int puntaje) {
        for (Misil m : misiles) {
            if (m.getPaisLanzador().equals(pais) && m instanceof Calificable) {
                try {
                    ((Calificable) m).calificarAmenaza(puntaje);
                } catch (CalificacionInvalidaException e) {
                    System.out.println("Error de calificación: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("No se encontró misil calificable lanzado por " + pais);
    }
}

