
package dao;

import entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class CurrencyExchangeDao implements IDao<CurrencyExchange>{

    final EntityManager entityManager;
    
    public CurrencyExchangeDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List list() {
        return entityManager.createQuery("Select c from Client c").getResultList();
    }
    @Override
    public void insert(CurrencyExchange t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(CurrencyExchange t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(CurrencyExchange t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
    
}
