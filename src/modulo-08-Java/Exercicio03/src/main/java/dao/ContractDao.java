package dao;

import entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class ContractDao implements IDao<Contract> {

    final EntityManager entityManager;

    public ContractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Contract c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(c);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Contract c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(c);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Contract c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(c);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Contract> list() {
        return entityManager.createQuery("Select p from Contract p").getResultList();
    }

}
