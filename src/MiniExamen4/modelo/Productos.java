package MiniExamen4.modelo;

public class Productos {

    private int cod_prod;
    private String nome;
    private double azucre_100g;
    private double calorias_100g;

    public Productos(int cod_prod, String nome) {
        this.cod_prod = cod_prod;
        this.nome = nome;
        this.azucre_100g = 0;
        this.calorias_100g = 0;
    }

    public int getCod_prod() {
        return cod_prod;
    }
    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getAzucre_100g() {
        return azucre_100g;
    }
    public void setAzucre_100g(double azucre_100g) {
        this.azucre_100g = azucre_100g;
    }
    public double getCalorias_100g() {
        return calorias_100g;
    }
    public void setCalorias_100g(double calorias_100g) {
        this.calorias_100g = calorias_100g;
    }
}
