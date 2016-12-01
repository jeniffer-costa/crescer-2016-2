package br.com.cwi.crescer.exercicio04;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author diiego
 */
public class AtorDao extends AbstractDao<Ator, Long>{
    
    final EntityManager entityManager;
    
    public AtorDao(EntityManager entityManager) {
        super(Ator.class);
        this.entityManager = entityManager;
    }
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Ator> findAll() {
        return this.getEntityManager().createQuery("select p from Ator p").getResultList();
    }
}
