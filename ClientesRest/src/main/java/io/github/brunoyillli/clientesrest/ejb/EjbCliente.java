package io.github.brunoyillli.clientesrest.ejb;

import io.github.brunoyillli.clientesrest.entity.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class EjbCliente {
    private EntityManager entityManager;

    public EjbCliente() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("clientePersistence");
        this.entityManager = emf.createEntityManager();
    }

    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public Cliente findByCodigo(int codigo) {
        return entityManager.find(Cliente.class, codigo);
    }

    public void addCliente(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public void putCliente(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void removeClienteByCodigo(int codigo) {
        Cliente cliente = entityManager.find(Cliente.class, codigo);
        if (cliente != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }
    }
}
