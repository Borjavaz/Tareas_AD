package MiniExamen6.modelo;

import java.io.Serializable;

public class Libro implements Serializable {

    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String descripcion;

    public Libro(int id, String titulo, String autor, int anoPublicacion, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAnoPublicacion() {
        return anoPublicacion;
    }
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                "titulo ='" + titulo + '\'' +
                ", autor  ='" + autor + '\'' +
                ", anoPublicacion =" + anoPublicacion + '\'' +
                ", descripcion =" + descripcion +
                '}';
    }
}
