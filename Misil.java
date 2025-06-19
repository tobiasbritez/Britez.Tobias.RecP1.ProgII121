package com.mycompany.misiles;
  
import java.time.LocalDate;

public abstract class Misil {
        protected String paisLanzador;
        protected LocalDate fechaLanzamiento;
        protected int alcance;
        protected String objetivo; 
        
        public Misil(String pais, LocalDate fecha, int alcance, String objetivo) {
        this.paisLanzador = pais;
        this.fechaLanzamiento = fecha;
        this.alcance = alcance;
        this.objetivo = objetivo;
    }

    public String getPaisLanzador() { return paisLanzador; }
    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public String getObjetivo() { return objetivo; }

    @Override
    public String toString() {
        return "Misil de " + paisLanzador + " lanzado el " + fechaLanzamiento + 
               ", objetivo: " + objetivo + ", alcance: " + alcance + "km";
    }
}
