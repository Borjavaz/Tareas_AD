package Hibernate.Parte1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class PokedexDAO {

    private SessionFactory sessionFactory;

    public PokedexDAO() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pokedex.class)
                .buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    // MÉTODOS CON OBXECTOS
    public void insertar(Pokedex pokemon) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pokemon);
        tx.commit();
        session.close();
    }

    public Pokedex buscarPorId(Long id) {
        Session session = sessionFactory.openSession();
        Pokedex pokemon = session.get(Pokedex.class, id);
        session.close();
        return pokemon;
    }

    public void actualizar(Pokedex pokemon) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(pokemon);
        tx.commit();
        session.close();
    }

    public void eliminarPorId(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Pokedex pokemon = session.get(Pokedex.class, id);
        if (pokemon != null) {
            session.delete(pokemon);
        }
        tx.commit();
        session.close();
    }

    // MÉTODOS CON QUERIES
    public List<Pokedex> listarTodos() {
        Session session = sessionFactory.openSession();
        Query<Pokedex> query = session.createQuery("FROM Pokedex", Pokedex.class);
        List<Pokedex> pokemons = query.getResultList();
        session.close();
        return pokemons;
    }

    public void actualizarPeso(Long id, Double novoPeso) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE Pokedex SET peso = :peso WHERE id = :id");
        query.setParameter("peso", novoPeso);
        query.setParameter("id", id);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    public void eliminarTodos() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Pokedex");
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    public Long contar() {
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("SELECT COUNT(p) FROM Pokedex p", Long.class);
        Long count = query.uniqueResult();
        session.close();
        return count;
    }
}