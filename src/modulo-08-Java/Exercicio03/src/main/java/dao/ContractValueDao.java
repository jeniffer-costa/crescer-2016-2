package dao;

import entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class ContractValueDao implements IDao<ContractValue> {

    final EntityManager entityManager;

    public ContractValueDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(ContractValue contractValue) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contractValue);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(ContractValue contractValue) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(contractValue);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ContractValue contractValue) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(contractValue);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<ContractValue> list() {
        return entityManager.createQuery("Select cv from Contract_Value cv").getResultList();
    }

}
