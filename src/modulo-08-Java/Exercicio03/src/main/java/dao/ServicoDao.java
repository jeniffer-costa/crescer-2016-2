package dao;

import entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class ServicoDao implements IDao<Servico>{
    
    final EntityManager entityManager;
    
    public ServicoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List list() {
        return entityManager.createQuery("Select c from Client c").getResultList();
    }
    @Override
    public void insert(Servico t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Servico t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Servico t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
