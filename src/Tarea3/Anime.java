package Tarea3;

import java.sql.Date;

public class Anime {
    // Los nombres de campo coinciden con los de la tabla
    private String nome;
    private String descripcion;
    private Date fecha; // Usar java.sql.Date para el campo DATE de la base de datos
    private int puntuacion;

    // Constructor completo
    public Anime(String nome, String descripcion, Date data, int puntuacion) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.fecha = data;
        this.puntuacion = puntuacion;
    }

    // --- Getters y Setters ---

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getData() { return fecha; }
    public void setData(Date data) { this.fecha = data; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    @Override
    public String toString() {
        return String.format("Anime [Nombre: %s, Descripción: %s, Fecha: %s, Puntuación: %d]",
                nome, descripcion, fecha, puntuacion);
    }
}