package MiniExamen2;

public class UnidadSororitas {
    private String nome;
    private int puntos;

    public UnidadSororitas(String nombre, int puntos) {
        this.nome = nombre;
        this.puntos = puntos;
    }

    // Getters necesarios para la impresión y la ordenación
    public String getNome() {
        return nome;
    }

    public int getPuntos() {
        return puntos;
    }

    // Método útil para la impresión de la salida solicitada
    @Override
    public String toString() {
        return nome + " - " + puntos;
    }
}
