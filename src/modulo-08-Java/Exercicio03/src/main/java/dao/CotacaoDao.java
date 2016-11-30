package dao;

import entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class CotacaoDao implements IDao<Cotacao>{

    final EntityManager entityManager;
    
    public CotacaoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List list() {
        return entityManager.createQuery("Select co from Cotacao co").getResultList();
    }
    @Override
    public void insert(Cotacao t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Cotacao t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param t
     */
    @Override
    public void delete(Cotacao t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    
}
