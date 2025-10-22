package MiniExamen5.modelo;

import java.io.Serializable;
import java.text.DecimalFormat; // Añadido para formato de salida

public class Transporte implements Serializable { // 1. Implementa Serializable

    // serialVersionUID es buena práctica en serialización
    private static final long serialVersionUID = 1L;

    private String  cod;
    private String tipo;
    private double capacidade;
    private double consumo;
    private double rendemento;

    // Constructor que recibe todos los datos (incluyendo el código de la BD)
    public Transporte(String cod, String tipo, double capacidade, double consumo) {
        this.cod = cod;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.consumo = consumo;
        // 3. Cálculo de rendimiento: capacidad / consumo
        // Se asegura que no se divida por cero, aunque el cálculo debería hacerse sobre los datos correctos
        if (consumo > 0) {
            this.rendemento = capacidade / consumo;
        } else {
            this.rendemento = 0.0; // Rendimiento cero si el consumo es cero o negativo
        }
    }

    // Se eliminó el constructor previo de 5 argumentos ya que el rendimiento se calcula aquí.

    @Override
    public String toString() {
        // Formato para mostrar el rendimiento con dos decimales
        DecimalFormat df = new DecimalFormat("#.00");
        // 4. Implementación del formato de salida requerido
        return cod + " " + tipo + " rendemento: " + df.format(rendemento);
    }

    // Getters y Setters (simplificados, solo se muestran los relevantes)
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public double getRendemento() {
        return rendemento;
    }
    public void setRendemento(double rendemento) {
        this.rendemento = rendemento;
    }
    public String getTipo() {
        return tipo;
    }
    public double getCapacidade() {
        return capacidade;
    }
    public double getConsumo() {
        return consumo;
    }
    // ... otros getters/setters
}