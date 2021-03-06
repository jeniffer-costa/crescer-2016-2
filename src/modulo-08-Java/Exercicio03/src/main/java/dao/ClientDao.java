package dao;

import entity.Client;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class ClientDao implements IDao<Client>{
    
    final EntityManager entityManager;
    
    public ClientDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List list() {
        return entityManager.createQuery("Select c from Client c").getResultList();
    }
    @Override
    public void insert(Client t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Client t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Client t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    
}
