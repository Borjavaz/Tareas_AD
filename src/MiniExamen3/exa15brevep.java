package MiniExamen3;

import MiniExamen3.util.ConexionBD;
import MiniExamen3.dao.PlatosDAO;
import MiniExamen3.modelo.Platos;
import MiniExamen3.util.Deserializar;

import java.sql.Connection;
import java.util.List;

public class exa15brevep {

    public static void main(String[] args) {

        List<Platos> platos = Deserializar.lerPlatos("platoss");
        PlatosDAO dao = new PlatosDAO();

        try (Connection con = ConexionBD.getConexion()) {
            for (Platos p : platos) {
                double graxaTotal = dao.calcularGraxaTotal(con, p.getCodigop());
                System.out.println(p.getCodigop() + " " + p.getNomep() + " graxatotal:" + graxaTotal);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
