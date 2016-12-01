package br.com.cwi.crescer.exercicio04;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diiego
 */
@Stateless
public class AtorBean extends AbstractDao<Ator, Long>{
    
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;
    
    public AtorBean() {
        super(Ator.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Ator> findAll() {
        return this.getEntityManager().createQuery("select p from Ator p").getResultList();
    }
}
