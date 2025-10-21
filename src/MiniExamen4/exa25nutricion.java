package MiniExamen4;

import MiniExamen4.util.Conexion;
import MiniExamen4.dao.ReceitaDAO;
import MiniExamen4.modelo.Receita;
import MiniExamen4.util.DeserializarFicheiro;

import java.sql.Connection;
import java.util.List;

public class exa25nutricion {

    public static void main(String[] args) {

        List<Receita> receita = DeserializarFicheiro.lerReceita("receitasnutri");
        ReceitaDAO dao = new ReceitaDAO();

        try (Connection con = Conexion.getConexion()) {
            for (Receita r : receita) {
                double sumaAzucres = dao.calcularSumaAzucares(con,r.getCodr());
                double sumaCalorias = dao.calcularSumaCalorias(con, r.getCodr());
                System.out.println(r.getCodr() + " " + r.getNome() + " media calorias: " + sumaCalorias + " | " +  " media azucres: " + sumaAzucres);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}